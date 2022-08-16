package com.example.projetoFinalLetsCode.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Data
@Entity
public class Cliente {

    @Id
    private Long id;

    private String nome;

    private String telefone;

    @Email(message = "Email invalido")
    private String email;

}
