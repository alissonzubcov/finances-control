package br.com.zubcovsoft.financas.domain.renda.model;

import br.com.zubcovsoft.financas.domain.categoriadespesa.model.CategoriaDespesa;
import br.com.zubcovsoft.financas.domain.categoriarenda.model.CategoriaRenda;
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
    LocalDateTime data;
    Boolean parcelado;
    Integer parcela;

    @ManyToOne
    CategoriaRenda categoriaRenda;

    @ManyToOne
    Usuario usuario;
}
