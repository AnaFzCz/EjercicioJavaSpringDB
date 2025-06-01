package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.model.Categoria;
import br.com.alura.gerenciador_pedidos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNome(String nome);

    List<Producto> findByCategoriaNome(String categoriaNome);

    List<Producto> findByPrecoGreaterThan(double preco);

    List<Producto> findByPrecoLessThan(double preco);

    List<Producto> findByNomeContaining(String termino);

    List<Producto> findByCategoriaNomeOrderByPrecoAsc(String categoriaNome);

    List<Producto> findByCategoriaNomeOrderByPrecoDesc(String categoriaNome);

    long countByCategoriaNome(String categoriaNome);

    long countByPrecoGreaterThan(double montoPropuesto);

    List<Producto> findByPrecoLessThanOrNomeContaining(Double precio, String termino);

    List<Producto> findTop3ByPrecoDesc();

    List<Producto> findTop5ByCategoriaNomeOrderByPrecoAsc(String categoriaNome);
}
