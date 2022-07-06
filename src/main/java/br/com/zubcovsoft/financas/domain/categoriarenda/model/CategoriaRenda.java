package br.com.zubcovsoft.financas.domain.categoriarenda.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
public class CategoriaRenda {
    @Id
    UUID id;
    String nome;
    String descricao;
}
