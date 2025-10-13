package com.techlab.domain.services;

import com.techlab.domain.model.Producto;
import com.techlab.repository.PedidoRepository;
import java.util.Scanner;

public class PedidoService {

  Scanner scanner = new Scanner(System.in);
  PedidoRepository repositorio = new PedidoRepository();

  public void crear(){
    System.out.println("creando");
  }

  public void listar(){
    System.out.println("listando");
  }

}
