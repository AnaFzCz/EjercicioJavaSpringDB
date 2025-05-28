package br.com.alura.gerenciador_pedidos;

import br.com.alura.gerenciador_pedidos.model.Categoria;
import br.com.alura.gerenciador_pedidos.model.Fornecedor;
import br.com.alura.gerenciador_pedidos.model.Pedido;
import br.com.alura.gerenciador_pedidos.model.Producto;
import br.com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.alura.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.alura.gerenciador_pedidos.repository.PedidoRepository;
import br.com.alura.gerenciador_pedidos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Principal {
    @Autowired
    private final ProductoRepository productoRepository;
    @Autowired
    private final PedidoRepository pedidoRepository;
    @Autowired
    private final CategoriaRepository categoriaRepository;
    @Autowired
    private final FornecedorRepository fornecedorRepository;


    public Principal(ProductoRepository productoRepository, PedidoRepository pedidoRepository, CategoriaRepository categoriaRepository, FornecedorRepository fornecedorRepository) {
        this.productoRepository = productoRepository;
        this.pedidoRepository = pedidoRepository;
        this.categoriaRepository = categoriaRepository;
        this.fornecedorRepository = fornecedorRepository;

    }

    public void cargarDatosIniciales() {

        Categoria categoriaJugueteria = new Categoria(1L, "Jugueteria");
        Categoria categoriaAlimentos = new Categoria(2L, "Alimentos");
        Categoria categoriaRopa = new Categoria(3L, "Ropa");
        Categoria categoriaElectronica = new Categoria(4L, "Electronica");

        Fornecedor fornecedorJugueteria = new Fornecedor(1L,"Jugueteria Mundo Toys");
        Fornecedor fornecedorAlimentos = new Fornecedor(2L, "Supermercado Ketal");
        Fornecedor fornecedorElectronica = new Fornecedor(3L,"Electrox");
        Fornecedor fornecedorRopas = new Fornecedor(4L,"Tolin");


        fornecedorRepository.saveAll(List.of(fornecedorJugueteria, fornecedorAlimentos, fornecedorElectronica, fornecedorRopas));

        Producto producto1 = new Producto("Bloques de madera", 150.00, categoriaJugueteria, fornecedorJugueteria);
        Producto producto2 = new Producto("Muñeca", 300.0, categoriaJugueteria, fornecedorJugueteria);
        Producto producto3 = new Producto("Juego de doctora dental", 80.00, categoriaJugueteria, fornecedorJugueteria);

        Producto producto4 = new Producto("frutilla", 10.00, categoriaAlimentos, fornecedorAlimentos);
        Producto producto5 = new Producto("durazno", 20.00, categoriaAlimentos, fornecedorAlimentos);
        Producto producto6 = new Producto("brocoli", 4.00, categoriaAlimentos, fornecedorAlimentos);

        Producto producto7 = new Producto("Blusa", 125.00, categoriaRopa, fornecedorRopas);
        Producto producto8 = new Producto("Pantalon", 50.00, categoriaRopa, fornecedorRopas);
        Producto producto9 = new Producto("Abrigo", 250.60, categoriaRopa, fornecedorRopas);

        Producto producto10 = new Producto("Mouse", 60.00, categoriaElectronica, fornecedorRopas);
        Producto producto11 = new Producto("Impresora", 700.60, categoriaElectronica, fornecedorRopas);
        Producto producto12 = new Producto("Notebook", 1000.60, categoriaElectronica, fornecedorRopas);


        categoriaJugueteria.setProducto(List.of(producto1, producto2, producto3));
        categoriaAlimentos.setProducto(List.of(producto4, producto5, producto6));
        categoriaRopa.setProducto(List.of(producto7, producto8, producto9));
        categoriaElectronica.setProducto(List.of(producto10, producto11, producto12));

        categoriaRepository.saveAll(List.of(categoriaJugueteria, categoriaAlimentos, categoriaRopa, categoriaElectronica));

        System.out.println("Categorias e seus produtos:");
        categoriaRepository.findAll().forEach(categoria -> {
            System.out.println("Categoria: " + categoria.getNome());
            categoria.getProducto().forEach(produto ->
                    System.out.println(" - Produto: " + produto.getNome())
            );
        });



    }
}
