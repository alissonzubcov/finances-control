package br.com.zubcovsoft.financas.domain.despesa.service;

import br.com.zubcovsoft.financas.domain.categoriamovimento.repository.CategoriaMovimentoDomainRepository;
import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import br.com.zubcovsoft.financas.domain.despesa.repository.DespesaDomainRepository;
import br.com.zubcovsoft.financas.domain.despesa.usecase.RegistrarDespesaUseCase;
import br.com.zubcovsoft.financas.domain.usuario.repository.UsuarioDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrarDespesaAppService implements RegistrarDespesaUseCase {

    private final DespesaDomainRepository despesaDomainRepository;
    private final UsuarioDomainRepository usuarioDomainRepository;
    private final CategoriaMovimentoDomainRepository categoriaMovimentoDomainRepository;

    private final ApplicationEventPublisher publisher;

    @Override
    public UUID handle(RegistrarDespesa cmd) {
        var usuario = usuarioDomainRepository.findById(cmd.getUsuario()).get();
        var categoria = categoriaMovimentoDomainRepository.findById(cmd.getCategoria()).get();

        var despesa = Despesa.builder()
                .categoriaMovimento(categoria)
                .usuario(usuario)
                .parcela(cmd.getParcela())
                .parcelado(cmd.getParcelado())
                .valor(cmd.getValor())
                .nome(cmd.getNome())
                .data(LocalDateTime.now())
                .build();
        this.despesaDomainRepository.save(despesa);

        publisher.publishEvent(DespesaRegistrada.from(despesa));

        return despesa.getId();
    }

    @Override
    public void on(DespesaRegistrada despesaRegistrada) {

    }
}
