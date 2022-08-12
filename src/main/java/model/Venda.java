package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Venda {

    @Id
    private Long id;
    private LocalDateTime dataVenda;

    private List<Produto> produtos;
    private BigDecimal valorTotal;
    private BigDecimal desconto;

}
