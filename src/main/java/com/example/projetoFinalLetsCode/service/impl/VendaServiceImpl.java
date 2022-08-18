package com.example.projetoFinalLetsCode.service.impl;

import com.example.projetoFinalLetsCode.model.Venda;
import com.example.projetoFinalLetsCode.repository.ProdutoRepository;
import com.example.projetoFinalLetsCode.repository.VendaRepository;
import com.example.projetoFinalLetsCode.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendaServiceImpl implements VendaService {
    final VendaRepository vendaRepository;

    public VendaServiceImpl(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    @Transactional
    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Venda> listar(String filtro, Pageable pageable) {

        final Venda produtoFiltro = new Venda();

        final ExampleMatcher exampleMatcher =
                ExampleMatcher
                        .matchingAny()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        final Example<Venda> produtoExample = Example.of(produtoFiltro, exampleMatcher);

        return vendaRepository.findAll(produtoExample, pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public Venda getId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID nao encontrado"));
    }
}
