package com.company;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FBPost implements Comparable<FBPost> {

    private int id;
    private String nome;
    private LocalDateTime instanteDeCriacao;
    private String conteudo;
    private int like;
    private List<String> comentarios;

    public FBPost (){
        this.id = 0;
        this.nome = "";
        this.instanteDeCriacao = LocalDateTime.now();
        this.conteudo = "";
        this.like = 0;
        this.comentarios = new ArrayList<>();
    }

    public FBPost(int id, String nome, LocalDateTime instanteDeCriacao, String conteudo,int likes, List<String> comentarios) {
        this.id = id;
        this.nome = nome;
        this.instanteDeCriacao = instanteDeCriacao;
        this.conteudo = conteudo;
        this.like = likes;
        List<String> copia = new ArrayList<>();
        for (String str : this.comentarios) {
            copia.add(str);
        }
        this.comentarios = copia;
    }

    public FBPost (FBPost post) {
        this.id = post.getId();
        this.nome = post.getNome();
        this.instanteDeCriacao = post.getInstanteDeCriacao();
        this.conteudo = post.getConteudo();
        this.like = post.getLike();
        this.comentarios = post.getComentarios();
    }

    public int getLike() { return like; }

    public void setLike(int like) { this.like = like; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getInstanteDeCriacao() {
        return instanteDeCriacao;
    }

    public void setInstanteDeCriacao(LocalDateTime instanteDeCriacao) {
        this.instanteDeCriacao = instanteDeCriacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<String> getComentarios() {
        List<String> copia = new ArrayList<>(this.comentarios.size());
        for (String str : this.comentarios) {
            copia.add(str);
        }
        return copia;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = new ArrayList<>();
        for (String str : comentarios) {
            this.comentarios.add(str);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FBPost fbPost = (FBPost) o;
        return getId() == fbPost.getId()
                && getInstanteDeCriacao() == fbPost.getInstanteDeCriacao()
                && getNome().equals(fbPost.getNome())
                && getConteudo().equals(fbPost.getConteudo())
                && getLike() == fbPost.getLike()
                && getComentarios().equals(fbPost.getComentarios());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FBPost { ");
        sb.append("id = ").append(id);
        sb.append(", nome = '").append(nome).append('\'');
        sb.append(", instanteDeCriacao = ").append(instanteDeCriacao);
        sb.append(", conteudo = '").append(conteudo).append('\'');
        sb.append(", likes = '").append(like).append('\'');
        sb.append(", comentarios = ").append(comentarios.toString());
        sb.append("}\n");
        return sb.toString();
    }

    public FBPost clone () {
        return new FBPost(this);
    }

    public int compareTo (FBPost f) {
        int r;
        if (this.id == f.getId()) r=0;
        else if (this.id < f.getId()) r=1;
        else r=-1;
        return r;
    }

    public void addComment (String comment) {
        this.comentarios.add(comment);
    }

    public void like () {
        this.like++;
    }

}
