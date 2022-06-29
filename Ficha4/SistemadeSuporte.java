package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SistemadeSuporte {

    private ArrayList<PedidoSuporte> pedidos;

    public List<PedidoSuporte> getPedidos() {
        List<PedidoSuporte> copiaPedidos = new ArrayList<>();

        for(PedidoSuporte pedido : this.pedidos) {
            copiaPedidos.add(pedido.clone());
        }

        return copiaPedidos;
    }

    public void setPedidos(List<PedidoSuporte> pedidos) {
        this.pedidos = new ArrayList<>();

        for(PedidoSuporte pedido : pedidos) {
            this.pedidos.add(pedido.clone());
        }
    }

    public SistemadeSuporte(List<PedidoSuporte> pedidos) {
        this.setPedidos(pedidos);
    }

    public SistemadeSuporte() {
        this.pedidos = new ArrayList<>();
    }

    public SistemadeSuporte(SistemadeSuporte sistemaSup) {
        this.setPedidos(sistemaSup.pedidos);
    }

    @Override
    public SistemadeSuporte clone() {
        return new SistemadeSuporte(this);
    }

    @Override
    public String toString() {
        return "SISTEMASUPORTE:\n" + "pedidos [ \n" + this.pedidos.toString() +
                "].\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemadeSuporte that = (SistemadeSuporte) o;
        return this.pedidos.equals(that.getPedidos());
    }

    public void inserePedido(PedidoSuporte pedido) {
        this.pedidos.add(pedido.clone());
    }

    public PedidoSuporte procuraPedido(String user, LocalDateTime data) {
        Iterator<PedidoSuporte> it = this.pedidos.iterator();

        PedidoSuporte result = null;
        PedidoSuporte aux;
        boolean encontrou = false;
        while (it.hasNext() && !encontrou) {
            aux = it.next();
            if (aux.getNomeClienteQueFezPedido().equals(user) && aux.getInstanteSubmissaoPedido().isEqual(data)) {
                result = aux.clone();
                encontrou = true;
            }
        }
        return result;
    }

    public void resolvePedido(PedidoSuporte pedido, String tecnico, String info) {
        Iterator<PedidoSuporte> it = this.pedidos.iterator();

        PedidoSuporte aux;
        boolean encontrou = false;
        while (it.hasNext() && !encontrou) {
            aux = it.next();
            if (aux.equals(pedido)) {
                aux.setQuemTratouPedido(tecnico);
                aux.setInformacaoSerTransmitidaCliente(info);
                aux.setInstanteConclusaoPedido(LocalDateTime.now());
                encontrou = true;
            }
        }
    }

    public List<PedidoSuporte> resolvidos() {
        List<PedidoSuporte> resolvidos = new ArrayList<>();
        Iterator<PedidoSuporte> it = this.pedidos.iterator();

        PedidoSuporte aux;
        while (it.hasNext()) {
            aux = it.next();
            if (aux.getInstanteConclusaoPedido() != null) {
                resolvidos.add(aux.clone());
            }
        }
        return resolvidos;

        //return this.pedidos.stream().filter(p -> p.getInstanteConclusaoPedido()!=null).collect(Collectors.toList());
    }


    public String colaboradorTop() {
        List<PedidoSuporte> resolvidos = this.resolvidos();

        List<PedidoSuporte> ordenados = resolvidos.stream().sorted(new ComparatorPedidodeSuporte()).toList();

        int count = 0;
        int max = 0;
        String strmax = null;
        String strant = null;
        String aux;
        for (PedidoSuporte p : ordenados) {
            aux = p.getQuemTratouPedido();
            if (strant == null) {
                strant = aux;
                count++;
            }
            else if (aux.equals(strant)) {
                count++;
                strant = aux;
            }
            else if (count>max) {
                max = count;
                count = 1;
                strmax = strant;
                strant = aux;
            }
            else {
                strant = aux;
                count = 1;
            }
        }

        if (count>max) strmax = strant;

        return strmax;
    }


    public List<PedidoSuporte> resolvidos(LocalDateTime inicio, LocalDateTime fim) {
        List<PedidoSuporte> resolvidos = new ArrayList<>();
        Iterator<PedidoSuporte> it = this.pedidos.iterator();

        PedidoSuporte aux;
        while (it.hasNext()) {
            aux = it.next();
            if (aux.getInstanteConclusaoPedido() != null && aux.getInstanteConclusaoPedido().isAfter(inicio) && aux.getInstanteConclusaoPedido().isBefore(fim)) {
                resolvidos.add(aux.clone());
            }
        }
        return resolvidos;
    }


    public double tempoMedioResolucao() {
        double media = 0;
        int count = 0;

        for (PedidoSuporte aux : this.pedidos) {
            if (aux.getInstanteConclusaoPedido() != null) {
                count++;
                Duration d = Duration.between(aux.getInstanteSubmissaoPedido(),aux.getInstanteConclusaoPedido());
                media += d.toMinutes();
            }
        }
        return media/count;

    }

    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim) {
        double media = 0;
        int count = 0;

        for (PedidoSuporte aux : this.pedidos) {
            if (aux.getInstanteConclusaoPedido() != null && aux.getInstanteConclusaoPedido().isAfter(inicio) && aux.getInstanteConclusaoPedido().isBefore(fim)) {
                count++;
                Duration d = Duration.between(aux.getInstanteSubmissaoPedido(),aux.getInstanteConclusaoPedido());
                media += d.toMinutes();
            }
        }
        return media/count;
    }


    public PedidoSuporte pedidoMaisLongo() {
        PedidoSuporte r = null;
        Duration max = Duration.ZERO;
        for (PedidoSuporte p : this.pedidos) {
            Duration d = Duration.between(p.getInstanteSubmissaoPedido(),p.getInstanteConclusaoPedido());
            if (d.compareTo(max) > 0) {
                r = p.clone();
                max = d;
            }
        }
        return r;
    }
/*
    public PedidoSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim) {

    }
*/
    public PedidoSuporte pedidoMaisCurto() {
        PedidoSuporte r = null;
        Duration min = null;
        for (PedidoSuporte p : this.pedidos) {
            Duration d = Duration.between(p.getInstanteSubmissaoPedido(),p.getInstanteConclusaoPedido());
            if (min == null) {
                min = d;
                r = p.clone();
            }
            else if (d.compareTo(min) < 0) {
                r = p.clone();
            }
        }
        return r;
    }

    /*
    public PedidoSuporte pedidoMaisCurto(LocalDateTime inicio, LocalDateTime fim) {

    }
    */






}
