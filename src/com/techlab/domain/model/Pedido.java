package com.techlab.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

  private static int contador = 0;

  private final int id;
  private List<LineaPedido> lineasPedido;

  public Pedido() {
    this.id = ++contador;
    this.lineasPedido = new ArrayList<LineaPedido>();
  }

  public void agregarProducto(Producto producto, int cantidad){
    lineasPedido.add(new LineaPedido(producto, cantidad));
  }

  public double calcularTotal(){
    double total = 0;
    for(LineaPedido linea: lineasPedido){
      total += linea.getSubtotal();
    }
    return total;
  }
}
