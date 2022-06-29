package com.company;

import java.util.Objects;

public class Lugar implements Comparable<Lugar> {

    /* * Matricula do veiculo estacionado */
    private String matricula ;
    /* * Nome do proprietario */
    private String nome ;
    /* * Tempo atribuido ao lugar , em minutos */
    private int minutos ;
    /* * Indica se lugar é permanente , ou de aluguer */
    private boolean permanente ;

    public String getMatricula () {
        return this.matricula;
    }

    public String getNome () {
        return this.nome;
    }

    public int getMinutos () {
        return this.minutos;
    }

    public boolean getPermanente () {
        return this.permanente;
    }

    public void setMatricula (String mat) {
        this.matricula = mat;
    }

    public void setNome (String nom) {
        this.nome = nom;
    }

    public void setMinutos (int min) {
        this.minutos = min;
    }

    public void setPermanente (boolean perms) {
        this.permanente = perms;
    }

    public Lugar () {
        this.matricula = "n/a";
        this.minutos = 0;
        this.permanente = false;
        this.nome = "n/a";
    }

    public Lugar (String mat, String nom, int min, boolean perms) {
        this.setMatricula(mat);
        this.setNome(nom);
        this.setMinutos(min);
        this.setPermanente(perms);
    }

    public Lugar (Lugar l) {
        this.matricula = l.getMatricula();
        this.nome = l.getNome();
        this.minutos = l.getMinutos();
        this.permanente = l.getPermanente();
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Lugar l = (Lugar) o;
        return this.getMatricula().compareTo(l.getMatricula()) == 0 &&
                this.getNome().compareTo(l.getNome()) == 0 &&
                this.getMinutos() == l.getMinutos() &&
                this.getPermanente() == l.getPermanente();
    }

    public Lugar clone () {
        return new Lugar(this);
    }

    public String toString() {
        return " [ LUGAR:\n" + "\tMatricula: " + this.matricula + "\n\tNome: " + this.nome +
               "\n\tMinutos: " + this.minutos + "\n\tPermanente: " + this.permanente + " ]\n";
    }

    public int compareTo (Lugar l) {
        if (this.equals(l)) return 0;
        else if (this.minutos < l.getMinutos()) return -1;
        else return 1;
    }
}
