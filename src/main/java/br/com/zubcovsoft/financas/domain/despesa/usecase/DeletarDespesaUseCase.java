package br.com.zubcovsoft.financas.domain.despesa.usecase;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface DeletarDespesaUseCase {

    void handle(UUID id);

}
