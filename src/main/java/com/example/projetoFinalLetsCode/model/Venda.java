package com.example.projetoFinalLetsCode.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataVenda;
    @ManyToMany(targetEntity = Produto.class, fetch = FetchType.EAGER)
    private List<Produto> produtos;
    private BigDecimal valorTotal;
    private BigDecimal desconto;
    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
    private Cliente cliente;
    @ManyToOne(targetEntity = Vendedor.class, fetch = FetchType.EAGER)
    private Vendedor vendedor;

}
