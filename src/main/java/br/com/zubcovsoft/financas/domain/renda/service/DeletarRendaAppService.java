package br.com.zubcovsoft.financas.domain.renda.service;

import br.com.zubcovsoft.financas.domain.despesa.repository.DespesaDomainRepository;
import br.com.zubcovsoft.financas.domain.despesa.usecase.DeletarDespesaUseCase;
import br.com.zubcovsoft.financas.domain.renda.usecase.DeletarRendaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeletarRendaAppService implements DeletarRendaUseCase {

    private final DespesaDomainRepository despesaDomainRepository;

    private final ApplicationEventPublisher publisher;

    @Override
    public void handle(UUID cmd) {
        this.despesaDomainRepository.deleteById(cmd);
    }

}
