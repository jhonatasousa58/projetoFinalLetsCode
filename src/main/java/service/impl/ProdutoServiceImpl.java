package service.impl;

import model.Produto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProdutoRepository;
import service.ProdutoService;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional
    public void excluir(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Produto> listar(String filtro, Pageable pageable) {

        final Produto produtoFiltro = new Produto();
        produtoFiltro.setNome(filtro);
        produtoFiltro.setDescricao(filtro);

        final ExampleMatcher exampleMatcher =
                ExampleMatcher
                        .matchingAny()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        final Example<Produto> produtoExample = Example.of(produtoFiltro, exampleMatcher);

        return produtoRepository.findAll(produtoExample, pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public Produto getId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID nao encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isEmpty() {
        return produtoRepository.count() == 0;
    }

    @Override
    @Transactional
    public void salvarLista(List<Produto> produtos) {
        produtoRepository.saveAll(produtos);
    }
}
