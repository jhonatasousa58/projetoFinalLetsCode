package com.example.projetoFinalLetsCode.service;

import com.example.projetoFinalLetsCode.model.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendedorService {
    Vendedor salvar(Vendedor vendedor);

    void excluir(Long idVendedor);

    Page<Vendedor> listar(String filtro, Pageable pageable);

    Vendedor getId(Long id);
}
