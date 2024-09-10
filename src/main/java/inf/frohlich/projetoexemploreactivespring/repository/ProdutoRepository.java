package inf.frohlich.projetoexemploreactivespring.repository;


import inf.frohlich.projetoexemploreactivespring.model.Produto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProdutoRepository extends R2dbcRepository<Produto,Long>{ //ReactiveCrudRepository<Produto, Long> {
}
