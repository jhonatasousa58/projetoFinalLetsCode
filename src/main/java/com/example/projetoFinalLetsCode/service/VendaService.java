package com.example.projetoFinalLetsCode.service;

import com.example.projetoFinalLetsCode.model.Venda;
import com.example.projetoFinalLetsCode.model.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface VendaService {
    Venda salvar(Venda venda);

    Page<Venda> listar(String filtro, Pageable pageable);

    Venda getId(Long id);
}
