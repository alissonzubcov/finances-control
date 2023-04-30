package br.com.zubcovsoft.financas.domain.categoriamovimento.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
public class CategoriaMovimento {
    @Id
    UUID id;
    String nome;
    String descricao;
    @Enumerated(EnumType.STRING)
    TipoMovimento tipo;

}
