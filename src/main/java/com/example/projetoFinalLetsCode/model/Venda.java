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
    private Long id;
    private LocalDateTime dataVenda;
    @ManyToMany(targetEntity = Produto.class, fetch = FetchType.EAGER)
    private List<Produto> produtos;
    private BigDecimal valorTotal;
    private BigDecimal desconto;
    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
    private Cliente cliente;

}
