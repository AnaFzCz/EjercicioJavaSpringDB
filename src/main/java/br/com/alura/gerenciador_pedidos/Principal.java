package br.com.alura.gerenciador_pedidos;

import br.com.alura.gerenciador_pedidos.model.Categoria;
import br.com.alura.gerenciador_pedidos.model.Pedido;
import br.com.alura.gerenciador_pedidos.model.Producto;
import br.com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.alura.gerenciador_pedidos.repository.PedidoRepository;
import br.com.alura.gerenciador_pedidos.repository.ProductoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    private ProductoRepository productoRepository;
    private PedidoRepository pedidoRepository;
    private CategoriaRepository categoriaRepository;


    public Principal(ProductoRepository productoRepository, PedidoRepository pedidoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.pedidoRepository = pedidoRepository;
        this.categoriaRepository = categoriaRepository;

    }


    public void guardaDatos() {
        Producto producto = new Producto("Lapices de colores", 80.0);
        Categoria categoria = new Categoria(1L, "Libreria");
        Pedido pedido = new Pedido(1L, LocalDate.now());
        productoRepository.save(producto);
        System.out.println(producto);
        categoriaRepository.save(categoria);
        System.out.println(categoria);
        pedidoRepository.save(pedido);
        System.out.println(pedido);


    }
}
