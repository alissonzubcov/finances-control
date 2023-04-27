package br.com.zubcovsoft.financas.domain.renda.projection;

import br.com.zubcovsoft.financas.domain.renda.model.Renda;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class RendaDTO {

    UUID id;
    BigDecimal valor;
    ZonedDateTime data;
    String categoria;

    public static RendaDTO from(Renda renda){
        return RendaDTO.builder()
                .id(renda.getId())
                .valor(renda.getValor())
                .data(ZonedDateTime.of(renda.getData(), ZoneId.of("UTC")))
                .categoria(renda.getCategoriaMovimento().getNome())
                .build();
    }

}
