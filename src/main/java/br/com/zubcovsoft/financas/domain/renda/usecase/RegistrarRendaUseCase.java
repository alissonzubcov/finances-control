package br.com.zubcovsoft.financas.domain.renda.usecase;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import br.com.zubcovsoft.financas.domain.renda.model.Renda;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface RegistrarRendaUseCase {

    UUID handle(RegistrarRenda registrarRenda);

    void on (RendaRegistrada rendaRegistrada);

    @Value
    @Builder
    class RegistrarRenda{
        UUID categoria;
        String nome;
        UUID usuario;
        LocalDateTime data;
        BigDecimal valor;
    }

    @Builder
    @Value
    class RendaRegistrada{
        BigDecimal valor;
        Boolean parcelado;
        String nome;
        Integer parcela;

        public static RendaRegistrada from(Renda renda){
            return RendaRegistrada.builder()
                    .valor(renda.getValor())
                    .nome(renda.getNome())
                    .build();
        }
    }
}
