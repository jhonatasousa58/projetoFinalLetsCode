package com.example.projetoFinalLetsCode.service.impl;

import com.example.projetoFinalLetsCode.model.Cliente;
import com.example.projetoFinalLetsCode.repository.ClienteRepository;
import com.example.projetoFinalLetsCode.service.ClienteService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public class ClienteServiceImpl implements ClienteService {
    final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void excluir(Long idProduto) {
        clienteRepository.deleteById(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> listar(String filtro, Pageable pageable) {

        final Cliente produtoFiltro = new Cliente();
        produtoFiltro.setNome(filtro);

        final ExampleMatcher exampleMatcher =
                ExampleMatcher
                        .matchingAny()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        final Example<Cliente> produtoExample = Example.of(produtoFiltro, exampleMatcher);

        return clienteRepository.findAll(produtoExample, pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID nao encontrado"));
    }
}
