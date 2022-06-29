package com.company;

public class Carro {


    //variaveis de instancia
    private String marca;
    private String modelo;
    private int anoConstrucao;
    private double consumo;
    private long kmsTotais;
    private double mediaConsumo;
    private int kmsUltimoPercurso;
    private double mediaConsumoUltimoPercurso;
    private double regeneracao;
    private int estado;

    //construtores
    public Carro() {
        this.marca = "";
        this.modelo = "";
        this.anoConstrucao = 0;
        this.consumo = 0;
        this.kmsTotais = 0;
        this.mediaConsumo = 0;
        this.kmsUltimoPercurso = 0;
        this.mediaConsumoUltimoPercurso = 0;
        this.regeneracao = 0;
        this.estado = 0;

    }

    public Carro(String marca, String modelo, int anoConstrucao, double consumo, long kmsTotais, double mediaConsumo, int kmsUltimoPercurso, double mediaConsumoUltimoPercurso, double regeneracao, int estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoConstrucao = anoConstrucao;
        this.consumo = consumo;
        this.kmsTotais = kmsTotais;
        this.mediaConsumo = mediaConsumo;
        this.kmsUltimoPercurso = kmsUltimoPercurso;
        this.mediaConsumoUltimoPercurso = mediaConsumoUltimoPercurso;
        this.regeneracao = regeneracao;
        this.estado = estado;
    }

    //getters e setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public long getKmsTotais() {
        return kmsTotais;
    }

    public void setKmsTotais(long kmsTotais) {
        this.kmsTotais = kmsTotais;
    }

    public double getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }

    public int getKmsUltimoPercurso() {
        return kmsUltimoPercurso;
    }

    public void setKmsUltimoPercurso(int kmsUltimoPercurso) {
        this.kmsUltimoPercurso = kmsUltimoPercurso;
    }

    public double getMediaConsumoUltimoPercurso() {
        return this.mediaConsumoUltimoPercurso;
    }

    public void setMediaConsumoUltimoPercurso(double mediaConsumoUltimoPercurso) {
        this.mediaConsumoUltimoPercurso = mediaConsumoUltimoPercurso;
    }

    public double getRegeneracao() {
        return regeneracao;
    }

    public void setRegeneracao(double regeneracao) {
        this.regeneracao = regeneracao;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    //metodos de instancia
    public void ligaCarro() {
        this.resetUltimaViagem();
        this.estado = 1;
    }

    public void desligaCarro() {
        this.estado = 0;
    }

    public void resetUltimaViagem() {
        this.kmsUltimoPercurso = 0;
        this.mediaConsumoUltimoPercurso = 0;
    }

    public void avancaCarro(double metros, double velocidade) {
        this.kmsUltimoPercurso += metros;
        this.kmsTotais += metros;
    }

    public void travaCarro(double metros) {
        this.kmsTotais += metros;
        this.kmsUltimoPercurso += metros;
        this.consumo -= this.regeneracao/metros;

    }

}
