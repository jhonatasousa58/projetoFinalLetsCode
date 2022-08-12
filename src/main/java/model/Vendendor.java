package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Vendendor {
    @Id
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String imagem;

    private BigDecimal saldo;
}
