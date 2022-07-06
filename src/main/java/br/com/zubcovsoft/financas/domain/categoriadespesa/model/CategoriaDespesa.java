package br.com.zubcovsoft.financas.domain.categoriadespesa.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
public class CategoriaDespesa {
    @Id
    UUID id;
    String nome;
    String descricao;
}
