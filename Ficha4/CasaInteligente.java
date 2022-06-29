package com.company;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CasaInteligente {

    private ArrayList<Lampada> lampadas;

    public CasaInteligente() {
        this.lampadas = new ArrayList<Lampada>();
    }

    public CasaInteligente(ArrayList<Lampada> lampadas) {
        this.lampadas = new ArrayList<Lampada>();
        for (Lampada l : lampadas) {
            this.lampadas.add(l);
        }
        //iteradores externos
        //this.lampadas = lampadas.stream().map(Lampada::clone).collect(Collectors.toList());
    }

    public CasaInteligente(CasaInteligente c) {
        this.lampadas = c.getLampadas();
    }

    public CasaInteligente clone() {
        return new CasaInteligente(this);
    }

    public ArrayList<Lampada> getLampadas() {
        ArrayList<Lampada> lamp = new ArrayList<Lampada>();
        for (Lampada l : this.lampadas) {
           lamp.add(l);
        }
        return lamp;
    }

    public void setLampadas(ArrayList<Lampada> lampadas) {
        this.lampadas = new ArrayList<Lampada>();
        for (Lampada l : lampadas) {
            this.lampadas.add(l);
        }
    }

    public void addLampada(Lampada l) {
        this.lampadas.add(l.clone());
    }

    public void ligaLampadaNormal(int index){
        Iterator<Lampada> itLampada = this.lampadas.iterator();
        int i = 0;
        while (itLampada.hasNext()){
            Lampada a = itLampada.next();
            if (i==index) {
                a.lampON();
            }
            i++;
        }
    }

    public void ligaLampadaEco(int index){
        Iterator<Lampada> itLampada = this.lampadas.iterator();
        int i = 0;
        while (itLampada.hasNext()){
            Lampada a = itLampada.next();
            if (i==index) {
                a.lampECO();
            }
            i++;
        }
    }

    public int qtEmEco() {
        Iterator<Lampada> itLampada = this.lampadas.iterator();
        int count = 0;
        while (itLampada.hasNext()) {
            Lampada a = itLampada.next();
            if (a.getModo() == Lampada.Modo.ECO) count++;
        }
        return count;
    }

    public void removeLampada(int index){
        Iterator<Lampada> itLampada = this.lampadas.iterator();
        int i = 0;
        while (itLampada.hasNext()) {
            itLampada.next();
            if (i == index) itLampada.remove();
            i++;
        }
    }

    public void ligaTodasEco(){
        this.lampadas.forEach(Lampada::lampECO);
    }

    public void ligaTodasMax(){
        this.lampadas.forEach(Lampada :: lampON);
    }

    public Set<Lampada> podiumEconomia(){
        Set<Lampada> conjunto = new TreeSet<>(Lampada::compareTo);
        Iterator<Lampada> it = this.lampadas.iterator();
        while(it.hasNext()) {
            Lampada a = it.next();
            conjunto.add(a.clone());
        }

        Lampada[] aux = new Lampada[conjunto.size()];
        conjunto.toArray(aux);

        Set<Lampada> podium = new TreeSet<>(Lampada::compareTo);
        int i = 0;
        for (i=0;i<aux.length && i<3;i++) {
            podium.add(aux[i]);
        }

        return podium;
    }


    public double consumoTotal(){
        double sum=0;
        for(Lampada l : this.lampadas) {
            sum+=l.getConsumoTotal();
        }
        return sum;
    }


    public Lampada maisGastadora(){
       Iterator<Lampada> it = this.lampadas.iterator();
       Lampada a;
       Lampada amax = null;
       double max = Integer.MIN_VALUE;
       while(it.hasNext()) {
           a = it.next();
           if (a.getConsumoTotal()>max) {
               max = a.getConsumoTotal();
               amax = a.clone();
           }
       }
       return amax;
    }

    public void reset(){
        this.lampadas.forEach(l -> l.setPeriodoConsumo(0));
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CasaInteligente{");
        sb.append("lampadas=").append(lampadas.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasaInteligente that = (CasaInteligente) o;
        return this.lampadas.equals(that.lampadas);
    }


}
