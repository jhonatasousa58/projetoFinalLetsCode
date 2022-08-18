package com.example.projetoFinalLetsCode.repository;

import com.example.projetoFinalLetsCode.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    Vendedor findByEmail(String email);
}
