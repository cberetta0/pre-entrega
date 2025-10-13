package com.techlab.repository;

import com.techlab.domain.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {

  private static ProductoRepository instancia;
  private List<Producto> productos;

  private ProductoRepository(){
    this.productos = new ArrayList<>();
  }

  public static ProductoRepository getInstance(){
    if(instancia == null){
      instancia = new ProductoRepository();
    }
    return instancia;
  }

  public void agregar(Producto producto){
    productos.add(producto);
  }

  public void listar(){
    productos.forEach(System.out::println);
  }

  public Producto buscarProducto(int id){
    for(Producto producto: productos){
      if(producto.getId() == id){
        return producto;
      }
    }
    return null;
  }

  public void eliminar(int id){
    Producto buscado = buscarProducto(id);
    productos.remove(buscado);
  }
}
