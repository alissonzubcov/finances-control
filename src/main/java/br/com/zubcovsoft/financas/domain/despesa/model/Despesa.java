package br.com.zubcovsoft.financas.domain.despesa.model;

import br.com.zubcovsoft.financas.domain.categoriadespesa.model.CategoriaDespesa;
import br.com.zubcovsoft.financas.domain.usuario.model.Usuario;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
public class Despesa {

    @Id
    UUID id;
    BigDecimal valor;
    LocalDateTime data;
    Boolean parcelado;
    Integer parcela;

    @ManyToOne
    CategoriaDespesa categoriaDespesa;

    @ManyToOne
    Usuario usuario;
}
