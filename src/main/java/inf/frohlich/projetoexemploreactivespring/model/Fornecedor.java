package inf.frohlich.projetoexemploreactivespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("forncedores")
public class Fornecedor {
    @Id
    private Long Id;
    private String nome;
}
