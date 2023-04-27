package br.com.zubcovsoft.financas.domain.despesa.service;

import br.com.zubcovsoft.financas.domain.despesa.repository.DespesaDomainRepository;
import br.com.zubcovsoft.financas.domain.despesa.usecase.DeletarDespesaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeletarDespesaAppService implements DeletarDespesaUseCase {

    private final DespesaDomainRepository despesaDomainRepository;

    private final ApplicationEventPublisher publisher;

    @Override
    public void handle(UUID cmd) {
        this.despesaDomainRepository.deleteById(cmd);
    }

}
