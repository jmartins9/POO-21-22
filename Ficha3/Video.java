package com.company;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



/**
 * Classe que implementa um video no Youtube.
 * O video é implementado atraves do seu Nome, Conteudo, Data de Carregamento, Resolucao, Duracao, Comentarios, Likes e Dislikes.
 */
public class Video {

    //variaveis de instancia
    private String nome;
    private String conteudo;
    private LocalDate dataCarregamento;
    private int resolucao;
    private double duracao;
    private ArrayList<String> array;
    private int likes;
    private int dislikes;

    /**
     * Contrutores da classe Video.
     * Declaração dos construtores por omissão (vazio),
     * parametrizado e de cópia .
     */

    /**
     * Construtor por omissão de Video.
     */
    public Video() {
        this.nome = "";
        this.conteudo = "";
        this.dataCarregamento = LocalDate.now();
        this.resolucao = 1080;
        this.duracao = 0;
        this.array = new ArrayList<String>(20);
        this.likes = 0;
        this.dislikes = 0;
    }

    /* *
     * Construtor parametrizado de Ponto .
     * Aceita como parâmetros os valores para cada coordenada .
     */
    public Video(String nome, String conteudo, LocalDate dataCarregamento, int resolucao, double duracao, ArrayList<String> array, int likes, int dislikes) {
        this.nome = new String(nome);
        this.conteudo = new String(conteudo);
        this.dataCarregamento = LocalDate.of(dataCarregamento.getYear(),dataCarregamento.getMonth(),dataCarregamento.getDayOfMonth());
        this.resolucao = resolucao;
        this.duracao = duracao;
        this.array = (ArrayList<String>) array.clone();
        this.likes = likes;
        this.dislikes = dislikes;
    }

    /**
     * Construtor de cópia de Ponto.
     */
    public Video(Video v) {
        this.nome = new String(v.getNome());
        this.conteudo = new String(v.getConteudo());
        this.dataCarregamento = LocalDate.of(v.getDataCarregamento().getYear(),v.getDataCarregamento().getMonth(),v.getDataCarregamento().getDayOfMonth());
        this.resolucao = v.getResolucao();
        this.duracao = v.getDuracao();
        this.array = (ArrayList<String>) v.getArray().clone();
        this.likes = v.getLikes();
        this.dislikes = v.getDislikes();
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCarregamento() {
        return dataCarregamento;
    }

    public void setDataCarregamento(LocalDate dataCarregamento) {
        this.dataCarregamento = dataCarregamento;
    }

    public int getResolucao() {
        return resolucao;
    }

    public void setResolucao(int resolucao) {
        this.resolucao = resolucao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public ArrayList<String> getArray() {
        return array;
    }

    public void setArray(ArrayList<String> array) {
        this.array = array;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void insereComentario(String comentario) {
        this.array.add(comentario);
    }

    public long qtsDiasDepois() {
        LocalDate now = LocalDate.now();
        return ChronoUnit.DAYS.between(now, this.dataCarregamento);
    }

    public void thumbsUp() {
        this.likes++;
    }

    public String processa() {
        return this.conteudo;
    }


    public String toString() {
        return "Video{" +
                "nome='" + nome + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataCarregamento=" + dataCarregamento +
                ", resolucao=" + resolucao +
                ", duracao=" + duracao +
                ", array=" + array +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return getResolucao() == video.getResolucao() &&
               video.getDuracao() == getDuracao()  &&
               getLikes() == video.getLikes() &&
               getDislikes() == video.getDislikes() &&
               getNome().compareTo(video.getNome()) == 0 &&
               getConteudo().compareTo(video.getConteudo()) == 0 &&
               getDataCarregamento().equals(video.getDataCarregamento()) &&
               getArray().equals(video.getArray());
    }

    public Video clone() {
        return new Video(this);
    }
}
