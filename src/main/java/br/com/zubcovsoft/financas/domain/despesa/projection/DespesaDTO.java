package br.com.zubcovsoft.financas.domain.despesa.projection;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class DespesaDTO {

    UUID id;
    BigDecimal valor;
    ZonedDateTime data;
    Integer parcela;
    String categoria;

    public static DespesaDTO from(Despesa despesa){
        return DespesaDTO.builder()
                .id(despesa.getId())
                .valor(despesa.getValor())
                .data(ZonedDateTime.of(despesa.getData(), ZoneId.of("UTC")))
                .parcela(despesa.getParcela())
                .categoria(despesa.getCategoriaMovimento().getNome())
                .build();
    }

}
