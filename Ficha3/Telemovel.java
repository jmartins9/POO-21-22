package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Telemovel {
    private String marca;
    private String modelo;
    private double displayX;
    private double displayY;
    private int capcidadeMensagens;
    private ArrayList<String> mensagens;
    private int capcidadeTotal;
    private int capcidadeFotos;
    private int capcidadeAplicacoes;
    private long espacoOcupado;
    private int numeroFotos;
    private int numeroAplicacoes;
    private ArrayList<String> aplicacoes;



    public Telemovel () {
        this.marca = "Xiaomi";
        this.modelo = "31";
        this.displayX = 10;
        this.displayY = 10;
        this.capcidadeMensagens = 100;
        this.mensagens = new ArrayList<>(20);
        this.capcidadeTotal = 100;
        this.capcidadeFotos = 0;
        this.capcidadeAplicacoes = 0;
        this.espacoOcupado = 0;
        this.numeroFotos = 0;
        this.numeroAplicacoes = 0;
        this.aplicacoes = new ArrayList<>(20);
    }

    public double getDisplayX() {
        return displayX;
    }

    public double getDisplayY() {
        return displayY;
    }

    public int getCapcidadeMensagens() {
        return capcidadeMensagens;
    }

    public int getCapcidadeTotal() {
        return capcidadeTotal;
    }

    public int getCapcidadeFotos() {
        return capcidadeFotos;
    }

    public int getCapcidadeAplicacoes() {
        return capcidadeAplicacoes;
    }

    public long getEspacoOcupado() {
        return espacoOcupado;
    }

    public int getNumeroFotos() {
        return numeroFotos;
    }

    public int getNumeroAplicacoes() {
        return numeroAplicacoes;
    }

    public ArrayList<String> getAplicacoes() {
        return (ArrayList<String>) aplicacoes.clone();
    }

    public ArrayList<String> getMensagens() {
        return (ArrayList<String>) mensagens.clone();
    }

    public String getMarca() { return new String(marca); }

    public void setMarca(String marca) {
        this.marca = new String(marca);
    }

    public String getModelo() { return new String(modelo); }

    public void setModelo(String modelo) {
        this.modelo = new String(modelo);
    }

    public void setDisplayX(double displayX) {
        this.displayX = displayX;
    }

    public void setDisplayY(double displayY) {
        this.displayY = displayY;
    }

    public void setCapcidadeMensagens(int capcidadeMensagens) { this.capcidadeMensagens = capcidadeMensagens; }

    public void setCapcidadeTotal(int capcidadeTotal) {
        this.capcidadeTotal = capcidadeTotal;
    }

    public void setCapcidadeFotos(int capcidadeFotos) {
        this.capcidadeFotos = capcidadeFotos;
    }

    public void setCapcidadeAplicacoes(int capcidadeAplicacoes) {
        this.capcidadeAplicacoes = capcidadeAplicacoes;
    }

    public void setEspacoOcupado(long espacoOcupado) {
        this.espacoOcupado = espacoOcupado;
    }

    public void setNumeroFotos(int numeroFotos) {
        this.numeroFotos = numeroFotos;
    }

    public void setNumeroAplicacoes(int numeroAplicacoes) {
        this.numeroAplicacoes = numeroAplicacoes;
    }

    public void setAplicacoes(ArrayList<String> aplicacoes) {
        this.aplicacoes = (ArrayList<String>) aplicacoes.clone();
    }

    public void setMensagens(ArrayList<String> mensagens) {
        this.mensagens = (ArrayList<String>) mensagens.clone();
    }



    public boolean existeEspaco(int numeroBytes) {
        return (this.espacoOcupado + numeroBytes < this.capcidadeTotal);
    }

    public void instalaApp (String nome, int tamanho) {
        if (this.espacoOcupado + tamanho < this.capcidadeTotal ) {
            this.aplicacoes.add(nome);
            this.espacoOcupado+=tamanho;
            this.capcidadeAplicacoes+=tamanho;
            this.numeroAplicacoes++;
        }
    }

    public void recebeMsg(String msg) {
        if(msg.length() + this.capcidadeMensagens < this.capcidadeMensagens ) {
            this.mensagens.add(msg);
            this.capcidadeMensagens += msg.length();
        }
    }

    public double tamMedioApps() {
        return (this.capcidadeAplicacoes/this.aplicacoes.size());
    }

    public String maiorMsg() {
        int max = Integer.MIN_VALUE;
        int imax = 0;
        int i;
        for(i=0;i<this.mensagens.size();i++) {
            if (this.mensagens.get(i).length() > max ) {
                max = this.mensagens.get(i).length();
                imax = i;
            }
        }
        if (i>0) {
            return this.mensagens.get(imax);
        }
        else return null;
    }

    public void removeApp(String nome, int tamanho) {
        int iapp = 0;
        int i;
        for(i=0;i<this.mensagens.size();i++) {
            if (nome.compareTo(this.mensagens.get(i)) == 0) {
                iapp = i;
            }
        }
        if (i>0) {
            this.aplicacoes.remove(iapp);
            this.capcidadeAplicacoes -= tamanho;
        }

    }




    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telemovel telemovel = (Telemovel) o;
        return Double.compare(telemovel.getDisplayX(), getDisplayX()) == 0 &&
               Double.compare(telemovel.getDisplayY(), getDisplayY()) == 0 &&
               getCapcidadeMensagens() == telemovel.getCapcidadeMensagens() &&
               getCapcidadeTotal() == telemovel.getCapcidadeTotal() &&
               getCapcidadeFotos() == telemovel.getCapcidadeFotos() &&
               getCapcidadeAplicacoes() == telemovel.getCapcidadeAplicacoes() &&
               getEspacoOcupado() == telemovel.getEspacoOcupado() &&
               getNumeroFotos() == telemovel.getNumeroFotos() &&
               getNumeroAplicacoes() == telemovel.getNumeroAplicacoes() &&
               Objects.equals(getMarca(), telemovel.getMarca()) &&
               Objects.equals(modelo, telemovel.modelo) && Objects.equals(mensagens, telemovel.mensagens) && Objects.equals(getAplicacoes(), telemovel.getAplicacoes());
    }
    //nao esta acabado


}
