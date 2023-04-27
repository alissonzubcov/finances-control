package br.com.zubcovsoft.financas.domain.despesa.usecase;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface RegistrarDespesaUseCase {

    UUID handle(RegistrarDespesa registrarDespesa);

    void on (DespesaRegistrada despesaRegistrada);

    @Value
    @Builder
    class RegistrarDespesa{
        UUID categoria;
        String nome;
        UUID usuario;
        LocalDateTime data;
        BigDecimal valor;
        Boolean parcelado;
        Integer parcela;
    }

    @Builder
    @Value
    class DespesaRegistrada{
        BigDecimal valor;
        Boolean parcelado;
        String nome;
        Integer parcela;

        public static DespesaRegistrada from(Despesa despesa){
            return DespesaRegistrada.builder()
                    .valor(despesa.getValor())
                    .parcela(despesa.getParcela())
                    .nome(despesa.getNome())
                    .parcelado(despesa.getParcelado()).build();
        }
    }
}
