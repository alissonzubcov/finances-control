package br.com.zubcovsoft.financas.domain.despesa.model;

import br.com.zubcovsoft.financas.domain.categoriamovimento.model.CategoriaMovimento;
import br.com.zubcovsoft.financas.domain.usuario.model.Usuario;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    BigDecimal valor;
    String nome;
    LocalDateTime data;
    Boolean parcelado;
    Integer parcela;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    CategoriaMovimento categoriaMovimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;
}
