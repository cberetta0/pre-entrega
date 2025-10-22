package com.techlab.domain.services;

import com.techlab.domain.model.Pedido;
import com.techlab.domain.model.Producto;
import com.techlab.repository.PedidoRepository;
import com.techlab.repository.ProductoRepository;
import java.util.Scanner;

public class PedidoService {

  Scanner scanner = new Scanner(System.in);
  PedidoRepository pedidoRrepositorio = PedidoRepository.getInstance();
  ProductoRepository productoRepositorio = ProductoRepository.getInstance();

  public void crear(){
    Pedido pedido = new Pedido();
    Producto producto;

    int id = -1;
    int cantidad;

    while(true){
      System.out.print("Ingrese, de a uno, los ids de los productos que desea agregar (0 para finalizar): ");
      id = scanner.nextInt();
      if(id == 0) break;

      System.out.print("Ingrese la cantidad requerida de producto: ");
      cantidad = scanner.nextInt();

      producto = productoRepositorio.buscarProducto(id);
      pedido.agregarProducto(producto, cantidad);
      System.out.println("Producto agregado con exito!\n");
    }

    pedidoRrepositorio.agregar(pedido);
    System.out.println("Pedido creado con exito!\n");
  }

  public void listar(){
    pedidoRrepositorio.listar();
  }

}
