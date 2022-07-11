package br.com.zubcovsoft.financas.stream;

import br.com.zubcovsoft.financas.domain.despesa.usecase.RegistrarDespesaUseCase.DespesaRegistrada;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DespesaSubscriber {

    @EventListener
    @Async
    public void whenDespesaRegistrada(DespesaRegistrada despesaRegistrada){
        System.out.println(despesaRegistrada.getValor());
    }
}
