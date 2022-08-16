package com.example.projetoFinalLetsCode.service;

import com.example.projetoFinalLetsCode.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
    Cliente salvar(Cliente cliente);

    void excluir(Long idCliente);

    Page<Cliente> listar(String filtro, Pageable pageable);

    Cliente getId(Long id);
}
