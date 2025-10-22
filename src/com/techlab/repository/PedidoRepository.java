package com.techlab.repository;

import com.techlab.domain.model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

  private static PedidoRepository instancia;
  private List<Pedido> pedidos;

  private PedidoRepository(){
    this.pedidos = new ArrayList<>();
  }

  public static PedidoRepository getInstance(){
    if(instancia == null){
      instancia = new PedidoRepository();
    }
    return instancia;
  }

  public void agregar(Pedido pedido) {
    pedidos.add(pedido);
  }

  public void listar(){
    for(Pedido pedido: pedidos){
      pedido.printPedido();
    }
  }
}
