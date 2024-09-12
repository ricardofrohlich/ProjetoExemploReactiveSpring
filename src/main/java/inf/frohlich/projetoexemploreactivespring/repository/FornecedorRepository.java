package inf.frohlich.projetoexemploreactivespring.repository;

import inf.frohlich.projetoexemploreactivespring.model.Fornecedor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FornecedorRepository extends R2dbcRepository<Fornecedor,Long>{
}
