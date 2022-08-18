package com.example.projetoFinalLetsCode.service.impl;

import com.example.projetoFinalLetsCode.model.Vendedor;
import com.example.projetoFinalLetsCode.repository.VendedorRepository;
import com.example.projetoFinalLetsCode.service.VendedorService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendedorServiceImpl implements VendedorService {
    final VendedorRepository vendedorRepository;

    public VendedorServiceImpl(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    @Transactional
    public Vendedor salvar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    @Transactional
    public void excluir(Long idProduto) {
        vendedorRepository.deleteById(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Vendedor> listar(String filtro, Pageable pageable) {

        final Vendedor produtoFiltro = new Vendedor();
        produtoFiltro.setNome(filtro);

        final ExampleMatcher exampleMatcher =
                ExampleMatcher
                        .matchingAny()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        final Example<Vendedor> produtoExample = Example.of(produtoFiltro, exampleMatcher);

        return vendedorRepository.findAll(produtoExample, pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public Vendedor getId(Long id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID nao encontrado"));
    }
}
