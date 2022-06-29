package com.company;

import java.time.LocalDateTime;

public class PedidoSuporte {

    private String nomeClienteQueFezPedido;
    private LocalDateTime instanteSubmissaoPedido;
    private String assuntoSerTratado;
    private String descricaoPedido;
    private String quemTratouPedido;
    private LocalDateTime instanteConclusaoPedido;
    private String informacaoSerTransmitidaCliente;

    public String getNomeClienteQueFezPedido() { return nomeClienteQueFezPedido; }

    public void setNomeClienteQueFezPedido(String nomeClienteQueFezPedido) { this.nomeClienteQueFezPedido = nomeClienteQueFezPedido; }

    public LocalDateTime getInstanteSubmissaoPedido() { return instanteSubmissaoPedido; }

    public void setInstanteSubmissaoPedido(LocalDateTime instanteSubmissaoPedido) { this.instanteSubmissaoPedido = instanteSubmissaoPedido; }

    public String getAssuntoSerTratado() { return assuntoSerTratado; }

    public void setAssuntoSerTratado(String assuntoSerTratado) { this.assuntoSerTratado = assuntoSerTratado; }

    public String getDescricaoPedido() { return descricaoPedido; }

    public void setDescricaoPedido(String descricaoPedido) { this.descricaoPedido = descricaoPedido; }

    public String getQuemTratouPedido() { return quemTratouPedido; }

    public void setQuemTratouPedido(String quemTratouPedido) { this.quemTratouPedido = quemTratouPedido; }

    public LocalDateTime getInstanteConclusaoPedido() { return instanteConclusaoPedido; }

    public void setInstanteConclusaoPedido(LocalDateTime instanteConclusaoPedido) { this.instanteConclusaoPedido = instanteConclusaoPedido; }

    public String getInformacaoSerTransmitidaCliente() { return informacaoSerTransmitidaCliente; }

    public void setInformacaoSerTransmitidaCliente(String informacaoSerTransmitidaCliente) { this.informacaoSerTransmitidaCliente = informacaoSerTransmitidaCliente; }

    public PedidoSuporte () {
        this.nomeClienteQueFezPedido = "";
        this.instanteSubmissaoPedido = null;
        this.assuntoSerTratado = "";
        this.descricaoPedido = "";
        this.quemTratouPedido = "";
        this.informacaoSerTransmitidaCliente = "";
        this.instanteConclusaoPedido = null;
    }

    public PedidoSuporte(String nomeClienteQueFezPedido, LocalDateTime instanteSubmissaoPedido, String assuntoSerTratado, String descricaoPedido, String quemTratouPedido, LocalDateTime instanteConclusaoPedido, String informacaoSerTransmitidaCliente) {
        this.nomeClienteQueFezPedido = nomeClienteQueFezPedido;
        this.instanteSubmissaoPedido = instanteSubmissaoPedido;
        this.assuntoSerTratado = assuntoSerTratado;
        this.descricaoPedido = descricaoPedido;
        this.quemTratouPedido = quemTratouPedido;
        this.instanteConclusaoPedido = instanteConclusaoPedido;
        this.informacaoSerTransmitidaCliente = informacaoSerTransmitidaCliente;
    }

    public PedidoSuporte(PedidoSuporte pedidoSuporte) {
        this.nomeClienteQueFezPedido = pedidoSuporte.getNomeClienteQueFezPedido();
        this.instanteSubmissaoPedido = pedidoSuporte.getInstanteSubmissaoPedido();
        this.assuntoSerTratado = pedidoSuporte.getAssuntoSerTratado();
        this.descricaoPedido = pedidoSuporte.getDescricaoPedido();
        this.quemTratouPedido = pedidoSuporte.getQuemTratouPedido();
        this.instanteConclusaoPedido = pedidoSuporte.getInstanteConclusaoPedido();
        this.informacaoSerTransmitidaCliente = pedidoSuporte.getInformacaoSerTransmitidaCliente();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoSuporte that = (PedidoSuporte) o;
        return getNomeClienteQueFezPedido().equals(that.getNomeClienteQueFezPedido())
                && getInstanteSubmissaoPedido().isEqual(that.getInstanteSubmissaoPedido())
                && getAssuntoSerTratado().equals(that.getAssuntoSerTratado())
                && getDescricaoPedido().equals(that.getDescricaoPedido())
                && getQuemTratouPedido().equals(that.getQuemTratouPedido())
                && getInstanteConclusaoPedido().isEqual(that.getInstanteConclusaoPedido())
                && getInformacaoSerTransmitidaCliente().equals(that.getInformacaoSerTransmitidaCliente());
    }


    @Override
    public String toString() {
        return "PedidoSuporte:\n" + "nomeClienteQueFezPedido = " + nomeClienteQueFezPedido + ";\n" +
                "instanteSubmissaoPedido = " + instanteSubmissaoPedido + ";\n" +
                "assuntoSerTratado = " + assuntoSerTratado + ";\n" +
                "descricaoPedido = " + descricaoPedido + ";\n" +
                "quemTratouPedido = " + quemTratouPedido + ";\n" +
                "instanteConclusaoPedido = " + instanteConclusaoPedido + ";\n" +
                "informacaoSerTransmitidaCliente = " + informacaoSerTransmitidaCliente + ".\n";
    }

    @Override
    public PedidoSuporte clone() {
        return new PedidoSuporte(this);
    }


}



