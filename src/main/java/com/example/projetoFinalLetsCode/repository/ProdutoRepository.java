package com.example.projetoFinalLetsCode.repository;

import com.example.projetoFinalLetsCode.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContaining(String nome);

    @Query("select p from Produto p where p.nome = :nome order by p.id")
    List<Produto> findProduto(@Param("nome") String nome);

    @Query(value = "select * from produto p where p.nome = :nome order by p.id", nativeQuery = true)
    List<Produto> findProdutoNative(@Param("nome") String nome);
}