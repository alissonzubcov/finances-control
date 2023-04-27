package br.com.zubcovsoft.financas.domain.renda.model;

import br.com.zubcovsoft.financas.domain.categoriamovimento.model.CategoriaMovimento;
import br.com.zubcovsoft.financas.domain.usuario.model.Usuario;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class Renda {
    @Id
    UUID id;
    BigDecimal valor;
    String nome;
    LocalDateTime data;
    Boolean parcelado;
    Integer parcela;

    @ManyToOne
    CategoriaMovimento categoriaMovimento;

    @ManyToOne
    Usuario usuario;
}
