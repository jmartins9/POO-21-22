package com.company;

import java.util.Comparator;

public class ComparatorPedidodeSuporte implements Comparator<PedidoSuporte> {

    public int compare (PedidoSuporte p1, PedidoSuporte p2) {
       return p1.getQuemTratouPedido().compareTo(p2.getQuemTratouPedido());
    }

}
