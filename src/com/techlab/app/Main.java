package com.techlab.app;

import com.techlab.domain.services.PedidoService;
import com.techlab.domain.services.ProductoService;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    ProductoService productoService = new ProductoService();
    PedidoService pedidoService = new PedidoService();
    int opcion;

    do{
      printMenu();
      opcion = scanner.nextInt();
      manejarOpcion(opcion, productoService, pedidoService);
    } while(opcion != 7);

    scanner.close();
    System.exit(0);
  }

  private static void printMenu(){

    System.out.println("""
    ====================================
    === SISTEMA DE GESTION - TECHLAB ===
    ====================================
    
    1) Agregar producto
    2) Listar productos
    3) Buscar/Actualizar producto
    4) Eliminar producto
    5) Crear un pedido
    6) Listar pedidos
    7) Salir
    """);

    System.out.print("Elija una opcion: ");
  }

  private static void manejarOpcion(int opcion, ProductoService productoService, PedidoService pedidoService) {

    switch(opcion){
      case 1:
        productoService.agregar();
        break;
      case 2:
        productoService.listar();
        break;
      case 3:
        productoService.buscar();
        break;
      case 4:
        productoService.eliminar();
        break;
      case 5:
        pedidoService.crear();
        break;
      case 6:
        pedidoService.listar();
        break;
      default:
        System.out.println("La opcion seleccionada no es valida, elija otra");
    }
  }
}