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
    if(producto.getStock() < cantidad) throw new RuntimeException("No hay suficiente stock de " + producto.getNombre());
    lineasPedido.add(new LineaPedido(producto, cantidad));
  }

  public double calcularTotal(){
    double total = 0;
    for(LineaPedido linea: lineasPedido){
      total += linea.getSubtotal();
    }
    return total;
  }

  public void printPedido(){
    System.out.println("Pedido #" + id);
    for(LineaPedido linea: lineasPedido){
      System.out.println("  -" + linea.getProducto().getNombre() + ", " + linea.getCantidad() + " unidades");
    }
    System.out.println("  Total de: $" + calcularTotal() + "\n");
  }
}
