package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Encomenda {

    private String nomeCliente;
    private int contribuintte;
    private int numeroCliente;
    private int numeroEncomenda;
    private LocalDate dataEncomenda;
    private ArrayList<Linhaencomenda> arrayEncomenda;


    public Encomenda(String nomeCliente, int contribuintte, int numeroCliente, int numeroEncomenda, LocalDate dataEncomenda, ArrayList<Linhaencomenda> arrayEncomendas) {
        this.nomeCliente = nomeCliente;
        this.contribuintte = contribuintte;
        this.numeroCliente = numeroCliente;
        this.numeroEncomenda = numeroEncomenda;
        this.dataEncomenda = dataEncomenda;
        for (Linhaencomenda l : arrayEncomendas)
            if (l!=null) this.arrayEncomenda.add(l.clone());
    }

    public Encomenda() {
        this.nomeCliente = "";
        this.contribuintte = -1;
        this.numeroCliente = -1;
        this.numeroEncomenda = -1;
        this.dataEncomenda = null;
        this.arrayEncomenda = new ArrayList<>();
    }

    public Encomenda(Encomenda encomenda) {
        this.nomeCliente = encomenda.getNomeCliente();
        this.contribuintte = encomenda.getContribuintte();
        this.numeroCliente = encomenda.getNumeroCliente();
        this.numeroEncomenda = encomenda.getNumeroEncomenda();
        this.dataEncomenda = encomenda.getDataEncomenda();
        this.arrayEncomenda = (ArrayList<Linhaencomenda>) encomenda.arrayEncomenda.clone();
    }

    public String getNomeCliente() { return nomeCliente; }

    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public int getContribuintte() { return contribuintte; }

    public void setContribuintte(int contribuintte) { this.contribuintte = contribuintte; }

    public int getNumeroCliente() { return numeroCliente; }

    public void setNumeroCliente(int numeroCliente) { this.numeroCliente = numeroCliente; }

    public int getNumeroEncomenda() { return numeroEncomenda; }

    public void setNumeroEncomenda(int numeroEncomenda) { this.numeroEncomenda = numeroEncomenda; }

    public LocalDate getDataEncomenda() { return dataEncomenda; }

    public void setDataEncomenda(LocalDate dataEncomenda) { this.dataEncomenda = dataEncomenda; }

    public ArrayList<Linhaencomenda> getArrayEncomenda() { return (ArrayList<Linhaencomenda>) arrayEncomenda.clone(); }

    public void setArrayEncomenda(ArrayList<Linhaencomenda> arrayEncomenda) { this.arrayEncomenda = (ArrayList<Linhaencomenda>) arrayEncomenda.clone(); }

    public double calculaValorTotal() {
        double total = 0;
        Iterator<Linhaencomenda> it = arrayEncomenda.iterator();
        while (it.hasNext()) {
            total += it.next().getValor();
        }
        return total;
    }

    public double calculaValorDesconto() {
        double total = 0;
        Iterator<Linhaencomenda> it = arrayEncomenda.iterator();
        while (it.hasNext()) {
            total += it.next().calculaValorDesconto();
        }
        return total;
    }

    public int numeroTotalProdutos() {
        return this.arrayEncomenda.size();
    }

    public void adicionaLinha(Linhaencomenda linha) {
        this.arrayEncomenda.add(linha.clone());
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        boolean existe = false;
        Iterator<Linhaencomenda> it = arrayEncomenda.iterator();
        while (it.hasNext() && !existe) {
            Linhaencomenda l = it.next();
            if (l.getReferencia().compareTo(refProduto) == 0) existe = true;
        }
        return existe;
    }

    public void removeProduto(String codProd) {
        boolean existe = false;
        Iterator<Linhaencomenda> it = arrayEncomenda.iterator();
        while (it.hasNext() && !existe) {
            Linhaencomenda l = it.next();
            if (l.getReferencia().compareTo(codProd) == 0) {
                it.remove();
                existe = true;
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Encomenda { ");
        sb.append("nomeCliente = '").append(nomeCliente).append('\'');
        sb.append(", contribuintte = ").append(contribuintte);
        sb.append(", numeroCliente = ").append(numeroCliente);
        sb.append(", numeroEncomenda = ").append(numeroEncomenda);
        sb.append(", dataEncomenda = ").append(dataEncomenda);
        sb.append(", arrayEncomenda = ").append(arrayEncomenda.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Encomenda clone() {
        return new Encomenda(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return getContribuintte() == encomenda.getContribuintte()
                && getNumeroCliente() == encomenda.getNumeroCliente()
                && getNumeroEncomenda() == encomenda.getNumeroEncomenda()
                && getNomeCliente().equals(encomenda.getNomeCliente())
                && getDataEncomenda().equals(encomenda.getDataEncomenda())
                && getArrayEncomenda().equals(encomenda.getArrayEncomenda());
    }


}
