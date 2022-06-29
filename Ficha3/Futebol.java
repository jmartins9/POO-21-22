package com.company;


import java.util.Objects;

public class Futebol {
    private int jogo; // se esta a 0, só se pode dar inicio ao jogo , se esta a 2, só é possível consultar resultado
    private int visitada;
    private int visitante;

    public Futebol(int jogo, int visitada, int visitante) {
        this.jogo = jogo;
        this.visitada = visitada;
        this.visitante = visitante;
    }

    public Futebol() {
        this.jogo = 0;
        this.visitada = 0;
        this.visitante = 0;
    }

    public Futebol(Futebol f) {
        this.visitante = f.getVisitante();
        this.visitada = f.getVisitada();
        this.jogo = f.getJogo();
    }

    public int getJogo() {
        return jogo;
    }

    public void setJogo(int jogo) {
        this.jogo = jogo;
    }

    public int getVisitada() {
        return visitada;
    }

    public void setVisitada(int visitada) {
        this.visitada = visitada;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    public void startGame() {
           this.jogo = 1;
    }

    public void endGame() {
        this.jogo = 0;

    }

    public void goloVisitado() {
        this.visitada++;

    }

    public void goloVisitante() {
        this.visitante++;
    }

    public String resultadoActual() {
        return "Visitada " + this.getVisitada() + " - " + this.getVisitante() + " Visitante";
    }

    public String toString() {
        return "Futebol{" +
                "jogo=" + jogo +
                ", visitada=" + visitada +
                ", visitante=" + visitante +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Futebol futebol = (Futebol) o;
        return getJogo() == futebol.getJogo() &&
               getVisitada() == futebol.getVisitada() &&
               getVisitante() == futebol.getVisitante();
    }

    public Futebol clone() {
        return new Futebol(this);
    }


}
