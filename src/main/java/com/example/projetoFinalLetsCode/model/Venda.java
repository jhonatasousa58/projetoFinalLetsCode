package com.example.projetoFinalLetsCode.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

}
