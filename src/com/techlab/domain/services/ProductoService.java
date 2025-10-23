package com.techlab.domain.services;

import com.techlab.domain.model.Producto;
import com.techlab.domain.utils.Utils;
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
    scanner.nextLine();

    System.out.print("Stock: ");
    stock = scanner.nextInt();
    scanner.nextLine();

    Producto producto = new Producto(Utils.formatearNombreProducto(nombre), precio, stock);

    repositorio.agregar(producto);

    System.out.println("Producto agregado con exito!\n");
  }

  public void listar(){
    repositorio.listar();
  }

  public void buscar(){
    String nombreOId;
    Producto producto;

    System.out.print("Ingrese el nombre o ID del producto que desea buscar: ");
    nombreOId = scanner.nextLine();

    try {
      int id = Integer.parseInt(nombreOId);
      producto = repositorio.buscarProducto(id);
    } catch (NumberFormatException e) {
      producto = repositorio.buscarProducto(nombreOId);
    }

    if (producto == null) {
      System.out.println("No se encontró ningún producto con ese identificador.");
    } else {
      System.out.println(producto);
    }
  }

  public void eliminar(){
    int id;
    Producto producto;
    String eliminar;

    System.out.print("Ingrese el id del producto a eliminar: ");
    id = scanner.nextInt();
    scanner.nextLine();

    producto = repositorio.buscarProducto(id);
    System.out.print("Esta seguro que desea eliminar " + producto.getNombre() + "? (si/no): ");
    eliminar = scanner.nextLine();

    if(eliminar.equalsIgnoreCase("si")){
      repositorio.eliminar(id);
      System.out.println(producto.getNombre() + " eliminado con exito\n");
    } else {
      System.out.println("Operacion cancelada\n");
    }
  }
}
