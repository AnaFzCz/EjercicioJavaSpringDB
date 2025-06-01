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

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


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

        Fornecedor fornecedorJugueteria = new Fornecedor(1L, "Jugueteria Mundo Toys");
        Fornecedor fornecedorAlimentos = new Fornecedor(2L, "Supermercado Ketal");
        Fornecedor fornecedorElectronica = new Fornecedor(3L, "Electrox");
        Fornecedor fornecedorRopas = new Fornecedor(4L, "Tolin");


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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del producto");

        System.out.println("**********************************************************");
        var producto = scanner.nextLine();
        List<Producto> nombreProductoLista = productoRepository.findByNome(producto);
        System.out.println("PRODUCTO: ");
        nombreProductoLista.forEach(p ->
                System.out.println(p.getNome() + " - " + p.getPreco()));

        System.out.println("**********************************************************");
        System.out.println("Ingresa la categoría: ");
        var categoria = scanner.next();
        List<Producto> nomeCategoriaLista = productoRepository.findByCategoriaNome(categoria);
        nomeCategoriaLista.forEach(c ->
                System.out.println(c.getNome()));
        System.out.println("**********************************************************");
        System.out.println("Ingresa el monto: ");
        var precioComparar = scanner.nextDouble();
        List<Producto> precioMayor = productoRepository.findByPrecoGreaterThan(precioComparar);
        precioMayor.forEach(c ->
                System.out.println(c.getNome() + " - " + c.getPreco()));

        System.out.println("**********************************************************");
        System.out.println("Ingresa el monto para ver los productos menores al monto : ");
        var precioMenorComparar = scanner.nextDouble();
        List<Producto> precioMenor = productoRepository.findByPrecoLessThan(precioMenorComparar);
        precioMenor.forEach(c ->
                System.out.println(c.getNome() + " - " + c.getPreco()));
        System.out.println("**********************************************************");

        System.out.println("Ingresa el producto a buscar: ");
        var terminoABuscar = scanner.next();
        List<Producto> terminoLista = productoRepository.findByNomeContaining(terminoABuscar);
        terminoLista.forEach(t ->
                System.out.println(t.getNome() + " " + t.getPreco() + " " + t.getCategoria()));
        System.out.println("**********************************************************");

        System.out.println("Producto sin fecha de entrega: ");

        List<Pedido> fechaEntregaLista = pedidoRepository.findByDataIsNull();
        fechaEntregaLista.forEach(f ->
                System.out.println(f.getProducto()));

        List<Pedido> fechaEntregaListaExiste = pedidoRepository.findByDataIsNotNull();
        fechaEntregaListaExiste.forEach(f ->
                System.out.println(f.getProducto()));
        System.out.println("**********************************************************");
        System.out.println("Ingresa la categoria para ver los precios ordenados de forma ascendente: ");
        var categoriaNome = scanner.next();
        List<Producto> categoriaOrdenAsc = productoRepository.findByCategoriaNomeOrderByPrecoAsc(categoriaNome);

        categoriaOrdenAsc.forEach(co ->
                System.out.println(co.getNome() + " - " + co.getPreco()));

        System.out.println("**********************************************************");
        System.out.println("Ingresa la categoria para ver los precios ordenados de forma descendente: ");
        var categoriaNomeD = scanner.next();
        List<Producto> categoriaOrdenDesc = productoRepository.findByCategoriaNomeOrderByPrecoDesc(categoriaNomeD);

        categoriaOrdenDesc.forEach(co ->
                System.out.println(co.getNome() + " - " + co.getPreco()));

        System.out.println("**********************************************************");
        System.out.println(" Ingresa la categoria de la cual quieres contar los productos: ");
        var contaProducto = scanner.nextLine();

        long cuentaProducto = productoRepository.countByCategoriaNome(contaProducto);

        System.out.println("cuentaProducto = " + cuentaProducto);


        System.out.println("**********************************************************");
        System.out.println(" Ingresa el monto propuesto: ");
        var montoPropuesto = scanner.nextDouble();

        long conteo = productoRepository.countByPrecoGreaterThan(montoPropuesto);

        System.out.println("Conteo de productos con precio mayor al ingresado = " + conteo);

        System.out.println("**********************************************************");
        System.out.println("Ingresa el valor : ");
        var buscaPrecoInferior = scanner.nextDouble();
        System.out.println("Ingresa el nombre del producto : ");
        var buscaNomeInferior = scanner.nextLine();

        List<Producto> productosDevolver = productoRepository.findByPrecoLessThanOrNomeContaining(buscaPrecoInferior, buscaNomeInferior);

        productosDevolver.forEach(pd ->
                System.out.println(pd.getNome() + " - " + pd.getPreco()));

        System.out.println("**********************************************************");
        System.out.println("Ingrese la fecha a buscar: ");
        var fecha = scanner.next();

        List<Pedido> listaFechasDespues = pedidoRepository.findByDataPedidoAfter(LocalDate.parse(fecha));
        listaFechasDespues.forEach(p ->
                System.out.println(p.getProducto()));

        System.out.println("**********************************************************");
        System.out.println("Ingrese la fecha a buscar: ");
        var fechaAntes = scanner.next();

        List<Pedido> listaFechasAntes = pedidoRepository.findByDataPedidoBefore(LocalDate.parse(fechaAntes));
        listaFechasAntes.forEach(pa ->
                System.out.println(pa.getProducto()));

        System.out.println("**********************************************************");
        System.out.println("Ingresa la fecha inicial : ");
        var fecha1 = scanner.next();
        System.out.println("Ingresa la fecha final : ");
        var fecha2 = scanner.next();

        List<Pedido> fechasEntre = pedidoRepository.findByDataPedidoBetween(LocalDate.parse(fecha1), LocalDate.parse(fecha2));

        fechasEntre.forEach(pf ->
                System.out.println(pf.getProducto()));


        System.out.println("**********************************************************");
        System.out.println("3 productos más caros: ");
        List<Producto> productosCaros = productoRepository.findTop3ByPrecoDesc();

        productosCaros.forEach(po ->
                System.out.println(po.getNome() + " - " + po.getPreco()));

        System.out.println("**********************************************************");
        System.out.println("5 productos más baratos: ");
        System.out.println("Ingresa la categoria:");
        var categoriaBaratos = scanner.next();
        List<Producto> productosBaratos = productoRepository.findTop5ByCategoriaNomeOrderByPrecoAsc(categoriaBaratos);

        productosBaratos.forEach(cb ->
                System.out.println(cb.getNome() + " - " + cb.getPreco()));

    }
}
