package br.com.zubcovsoft.financas.domain.usuario.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
public class Usuario {
    @Id
    UUID id;
    String nome;
    String email;
    String senha;
    BigDecimal salario;
}
