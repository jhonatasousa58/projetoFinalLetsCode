package com.example.projetoFinalLetsCode.repository;

import com.example.projetoFinalLetsCode.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);

}
