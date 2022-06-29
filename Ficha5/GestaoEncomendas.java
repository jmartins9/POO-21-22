package com.company;

import java.time.LocalDate;
import java.util.*;


public class GestaoEncomendas {
    private Map<Integer,Encomenda> gestao;

    public GestaoEncomendas() {
        this.gestao = new HashMap<>();
    }

    public GestaoEncomendas(Map<Integer,Encomenda> gestao) {
        this.setGestao(gestao);
    }

    public Map<Integer, Encomenda> getGestao() {
        Map<Integer,Encomenda> copia = new HashMap<>(this.gestao.size());
        for (int Nenc : this.gestao.keySet()) {
            copia.put(Nenc,this.gestao.get(Nenc).clone());
        }
        return copia;
    }

    public void setGestao(Map<Integer, Encomenda> gestao) {
        this.gestao = new HashMap<>();
        for (int Nenc : gestao.keySet()) {
            this.gestao.put(Nenc,gestao.get(Nenc).clone());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestaoEncomendas that = (GestaoEncomendas) o;
        return gestao.equals(that.gestao);
    }

    @Override
    public String toString() {
        return "GestaoEncomendas { " + " gestao = " + gestao.toString() +
                " }\n";
    }

    public Set<Integer> todosCodigosEnc() {
        Set<Integer> copia = new TreeSet<>();
        copia.addAll(this.gestao.keySet());
        return copia;
    }

    public void addEncomenda(Encomenda enc) {
        this.gestao.put(enc.getNEnc(),enc.clone());
    }

    public Encomenda getEncomenda(int codEnc) {
        return this.gestao.get(codEnc).clone();
    }

    public void removeEncomenda(int codEnc) {
        this.gestao.remove(codEnc);
    }

    public int encomendaComMaisProdutos() {

        int codMax = -1;
        int nprodMax = -1;
        int aux;

        for (int Nenc : this.gestao.keySet()) {
            aux = this.getEncomenda(Nenc).numeroTotalProdutos();
            if (aux > nprodMax) {
                codMax = Nenc;
                nprodMax = aux;
            }
        }
        return codMax;

        /*
        Encomenda e = this.gestao.values().stream().max(new Comparator<Encomenda>() {
            @Override
            public int compare(Encomenda o1, Encomenda o2) {
                int r;
                if (o1.numeroTotalProdutos() == o2.numeroTotalProdutos()) r = 0;
                else if (o1.numeroTotalProdutos() > o2.numeroTotalProdutos()) r = 1;
                else r = -1;
                return r;
            }
        }).orElse(null);
        if (e!=NULL) return e.getNEnc();
        else return -1;
        */
    }


    public Set<Integer> encomendasComProduto(String codProd) {
        Set<Integer> encomendas = new TreeSet<>();

        for (Encomenda enc : this.gestao.values()) {
            if (enc.existeProdutoEncomenda(codProd)) encomendas.add(enc.getNEnc());
        }

        return encomendas;
    }

    public Set<Integer> encomendasAposData(LocalDate d) {
        Set<Integer> encomendas = new TreeSet<>();

        for (Encomenda enc : this.gestao.values()) {
            if (enc.getData().isAfter(d)) encomendas.add(enc.getNEnc());
        }

        return encomendas;
    }


    public Set<Encomenda> encomendasValorDecrescente() {
        Set<Encomenda> encomendas = new TreeSet<>();

        for (Encomenda enc : this.gestao.values()) {
            encomendas.add(enc.clone());
        }
        return encomendas;
    }



    public Map<String, List<Integer>> encomendasDeProduto() {
        Map<String, List<Integer>> prodEncomedas = new HashMap<>();

        for (Encomenda enc : this.gestao.values()   ) {
             for (String codProd : enc.getListaProdutos()) {
                 if (!prodEncomedas.containsKey(codProd)) {
                     List<Integer> lista = new ArrayList<>();
                     lista.add(enc.getNEnc());
                     prodEncomedas.put(codProd, lista);
                 }
                 else prodEncomedas.get(codProd).add(enc.getNEnc());
             }
        }

        return prodEncomedas;
    }

}
