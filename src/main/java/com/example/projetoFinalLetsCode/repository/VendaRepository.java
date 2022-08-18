package com.example.projetoFinalLetsCode.repository;

import com.example.projetoFinalLetsCode.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
