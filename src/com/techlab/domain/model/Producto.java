package com.techlab.domain.model;

public class Producto {

  private static int contador = 0;

  private final int id; //final para que solo pueda asignarse una vez
  private String nombre;
  private double precio;
  private int stock;

  public Producto(String nombre, double precio, int stock) {
    this.id = ++contador;
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
  }

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return """
       Producto %d:
        -Nombre: %s
        -Precio: $%.2f
        -Stock: %d
    """.formatted(id, nombre, precio, stock);
  }
}
