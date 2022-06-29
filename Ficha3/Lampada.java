package com.company;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Lampada {

    //variaveis instancia
    private int estado; //0 - desligada, 1-eco, 2-ligada
    private int consumo;
    private long momentoCriacao;

    public Lampada() {
        this.estado = 2;
        this.consumo = 2;
        this.momentoCriacao = System.currentTimeMillis();;
    }

    public Lampada(int estado,int consumo, long momentoCriacao) {
        this.estado = estado;
        this.consumo = consumo;
        this.momentoCriacao = momentoCriacao;
    }

    public Lampada (Lampada l) {
        this.estado = l.getEstado();
        this.consumo = l.getConsumo();
        this.momentoCriacao = l.getMomentoCriacao();
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public long getMomentoCriacao() {
        return momentoCriacao;
    }

    public void setMomentoCriacao(long momentoCriacao) {
        this.momentoCriacao = momentoCriacao;
    }

    public void lampON() {
        this.setEstado(2);
        this.setConsumo(2);
        this.setMomentoCriacao(System.currentTimeMillis());
    }

    public void lampOFF() {
        this.setEstado(0);
        this.setConsumo(0);
        this.setMomentoCriacao(0);
    }

    public void lampECO() {
        this.setEstado(1);
        this.setConsumo(1);
    }

    public double totalConsumo() {
        return ((System.currentTimeMillis()-this.momentoCriacao)*this.getConsumo());
    }

    public String toString() {
        return "Lampada{" +
                "estado=" + estado +
                ", consumo=" + consumo +
                ", dataCriacao=" + momentoCriacao +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lampada lampada = (Lampada) o;
        return getEstado() == lampada.getEstado() &&
               getConsumo() == lampada.getConsumo() &&
               getMomentoCriacao() == lampada.getMomentoCriacao();
    }

    public Lampada clone (Lampada l) {
        return new Lampada(l);
    }


}
