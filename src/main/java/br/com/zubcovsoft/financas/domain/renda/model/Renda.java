package br.com.zubcovsoft.financas.domain.renda.model;

import br.com.zubcovsoft.financas.domain.categoriamovimento.model.CategoriaMovimento;
import br.com.zubcovsoft.financas.domain.usuario.model.Usuario;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Renda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    BigDecimal valor;
    String nome;
    LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    CategoriaMovimento categoriaMovimento;

    @ManyToOne
    Usuario usuario;
}
