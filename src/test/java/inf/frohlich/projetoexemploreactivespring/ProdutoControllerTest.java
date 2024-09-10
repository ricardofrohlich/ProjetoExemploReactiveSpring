package inf.frohlich.projetoexemploreactivespring;

import inf.frohlich.projetoexemploreactivespring.controller.ProdutoController;
import inf.frohlich.projetoexemploreactivespring.model.Produto;
import inf.frohlich.projetoexemploreactivespring.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@WebFluxTest(ProdutoController.class)
public class ProdutoControllerTest {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ProdutoRepository  produtoRepository;

    private Produto produto;
    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        produto = new Produto(1L, "Coca", 5.0); // Certifiqu
    }
    @Test
    public void testFindAll(){
        doReturn(Flux.just(produto)).when(produtoRepository).findAll();

        webClient.get().uri("/api/produtos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Produto.class)
                .hasSize(1)
                .contains(produto);

        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    public void testFindById(){
        doReturn(Mono.just(produto)).when(produtoRepository).findById(1L);
        webClient.get().uri("/api/produtos/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Produto.class)
                .isEqualTo(produto);

        verify(produtoRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveProduto(){
        Produto newProduto = new Produto(null, "Pepsi", 4.0);
        Produto produtoSalvo = new Produto(2L, "Pepsi", 4.0);

        doReturn(Mono.just(produtoSalvo)).when(produtoRepository).save(newProduto);

        webTestClient.post().uri("/api/produtos")
                .bodyValue(newProduto)//enviando o novo produto sem o ID
                .exchange()
                .expectStatus().isOk() //Esperando o status OK = 200
                .expectBody(Produto.class)
                .isEqualTo(produtoSalvo); //
        verify(produtoRepository,times(1)).save(newProduto);
    }

    @Test
    public void testDeleteProduto(){
        doReturn(Mono.empty()).when(produtoRepository).deleteById(1L);
        webTestClient.delete().uri("/api/produtos/1")
                .exchange()
                .expectStatus().isOk();

        verify(produtoRepository, times(1)).deleteById(1L);
    }
}
