package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Parque {


    private String nome;
    private Map<String,Lugar> lugares;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Lugar> getLugares() {
        Map<String,Lugar> copia = new HashMap<>();

        for (String str : this.lugares.keySet()) {
            copia.put(str,this.lugares.get(str).clone());
        }

        return copia;
    }

    public void setLugares(Map<String, Lugar> lugares) {
        Map<String,Lugar> copia = new HashMap<>();

        for (String str : lugares.keySet()) {
            copia.put(str,lugares.get(str).clone());
        }

        this.lugares = copia;
    }

    public Parque () {
        this.nome = "n/a";
        this.lugares = new HashMap<>();
    }

    public Parque (String nome, Map<String,Lugar> lugares) {
        this.nome = nome;
        this.setLugares(lugares);
    }

    public Parque (Parque parque) {
        this.nome = parque.nome;
        this.lugares = parque.getLugares();
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Parque p = (Parque) o;
        return this.nome.compareTo(p.getNome())==0 &&
                this.lugares.equals(p.getLugares());
    }

    public String toString () {
        return "[ Parque: " + this.nome + "\n\t" + this.lugares.toString() + " ]\n";
    }

    public Parque clone () {
        return new Parque(this);
    }

    public void addLugar (Lugar lugar) {
        this.lugares.put(lugar.getMatricula(),lugar.clone());
    }

    public void removeLugar (String matricula) {
        this.lugares.remove(matricula);
    }

    public Set<String> matriculasParque () {
        Set<String> copia = new TreeSet<>();

        copia.addAll(this.lugares.keySet());

        return copia;
    }

    public void setTime (String matricula, int tempo) {
        Lugar l = this.lugares.get(matricula);
        l.setMinutos(tempo);
    }

    public int minutosAtribuidos () {
        Iterator<Lugar> itl = this.lugares.values().iterator();
        int count = 0;

        while (itl.hasNext()) {
            count += itl.next().getMinutos();
        }

        return count;
    }

    // OU

    public int minutosAtribuidos2 () {
        return this.lugares.values().stream().mapToInt(Lugar :: getMinutos).sum();
    }

    public boolean existeLugar (String matricula) {
        return this.lugares.values().stream().filter(Lugar :: getPermanente).anyMatch(l -> matricula.equals(l.getMatricula()));
    }

    public List<String>  listMatriculasxTempo (int tempo) {
        Iterator<Lugar> it = this.lugares.values().iterator();
        List<String> list = new ArrayList<>();

        while (it.hasNext()) {
            Lugar l = it.next();
            if (l.getMinutos()>tempo && l.getPermanente()) {
                list.add(l.getMatricula());
            }
        }
        return list;
    }

    // OU

    public List<String> listMatriculasxTempo2 (int tempo) {
        return this.lugares.values().stream().filter(l -> l.getMinutos()>tempo && l.getPermanente()).map(Lugar :: getMatricula).collect(Collectors.toList());
    }

    public Set<Lugar> copiaLugares () {
        Set<Lugar> sl = new TreeSet<>();

        for (Lugar l : this.lugares.values()) {
            sl.add(l.clone());
        }

        return sl;
    }

    public Lugar getLugar (String matricula) {
        return this.lugares.get(matricula);
    }


}
