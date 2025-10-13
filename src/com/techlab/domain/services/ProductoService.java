package com.techlab.domain.services;

import com.techlab.domain.model.Producto;
import com.techlab.repository.ProductoRepository;
import java.util.Scanner;

public class ProductoService {

  Scanner scanner = new Scanner(System.in);
  ProductoRepository repositorio = ProductoRepository.getInstance();

  public void agregar(){
    String nombre;
    double precio;
    int stock;

    System.out.println("Ingrese la siguiente informacion:");

    System.out.print("Nombre: ");
    nombre = scanner.nextLine();

    System.out.print("Precio: ");
    precio = scanner.nextDouble();

    System.out.print("Stock: ");
    stock = scanner.nextInt();

    Producto producto = new Producto(nombre, precio, stock);

    repositorio.agregar(producto);

    System.out.println("Producto agregado con exito!");
  }

  public void listar(){
    repositorio.listar();
  }

  public Producto buscar(){
    return new Producto("", 23, 23);
  }

  public void eliminar(){
    int id;
    Producto producto;
    boolean eliminar;

    System.out.println("Ingrese el id del producto a eliminar: ");
    id = scanner.nextInt();

    producto = repositorio.buscarProducto(id);
    System.out.println("Esta seguro que desea eliminar " + producto.getNombre() + "? true o false");
    eliminar = scanner.nextBoolean();

    if(eliminar){
      repositorio.eliminar(id);
    } else {
      System.out.println("Operacion cancelada");
    }
  }
}
