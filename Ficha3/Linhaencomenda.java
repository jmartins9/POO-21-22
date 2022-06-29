package com.company;

public class Linhaencomenda {

    private String  referencia;
    private String descricao;
    private double valor;
    private double quantidade;
    private double impostos;
    private double desconto;

    public Linhaencomenda() {
        this.referencia = "";
        this.descricao = "";
        this.valor = 0;
        this.impostos = 0;
        this.desconto = 0;
        this.quantidade = 0;
    }

    public Linhaencomenda(String referencia, String descricao, double valor, double quantidade, double impostos, double desconto) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.impostos = impostos;
        this.desconto = desconto;
    }


    public Linhaencomenda(Linhaencomenda encomenda) {
        this.referencia = encomenda.referencia;
        this.descricao = encomenda.descricao;
        this.valor = encomenda.valor;
        this.quantidade = encomenda.quantidade;
        this.impostos = encomenda.impostos;
        this.desconto = encomenda.desconto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getImpostos() {
        return impostos;
    }

    public void setImpostos(double impostos) {
        this.impostos = impostos;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double calculaValorLinhaEnc() {
        double v = this.valor-this.valor*(this.desconto/100);
        return this.valor*(this.impostos/100) + v;
     }

    public double calculaValorDesconto() {
        return this.valor * (this.desconto / 100);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Linhaencomenda { ");
        sb.append("referencia = ").append(referencia);
        sb.append(", descricao = '").append(descricao).append('\'');
        sb.append(", valor = ").append(valor);
        sb.append(", quantidade = ").append(quantidade);
        sb.append(", impostos = ").append(impostos);
        sb.append(", desconto = ").append(desconto);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linhaencomenda encomenda = (Linhaencomenda) o;
        return getReferencia().equals(encomenda.getReferencia()) &&
               encomenda.getValor() == getValor() &&
               encomenda.getQuantidade() == getQuantidade() &&
               encomenda.getImpostos() == getImpostos() &&
               encomenda.getDesconto() == getDesconto() &&
               getDescricao().equals(encomenda.getDescricao());
    }

    @Override
    public Linhaencomenda clone() { return new Linhaencomenda(this); }


}
