package inf.frohlich.projetoexemploreactivespring.service;

import inf.frohlich.projetoexemploreactivespring.model.Produto;
import inf.frohlich.projetoexemploreactivespring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService { //REST
    @Autowired
    private ProdutoRepository produtoRepository;

    public Flux<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Mono<Produto> save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Void> deleteById(Long id) {
        return produtoRepository.deleteById(id);
    }
}


