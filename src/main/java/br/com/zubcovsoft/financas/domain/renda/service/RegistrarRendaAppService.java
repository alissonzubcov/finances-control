package br.com.zubcovsoft.financas.domain.renda.service;

import br.com.zubcovsoft.financas.domain.categoriamovimento.repository.CategoriaMovimentoDomainRepository;
import br.com.zubcovsoft.financas.domain.renda.model.Renda;
import br.com.zubcovsoft.financas.domain.renda.repository.RendaDomainRepository;
import br.com.zubcovsoft.financas.domain.renda.usecase.RegistrarRendaUseCase;
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
public class RegistrarRendaAppService implements RegistrarRendaUseCase {

    private final RendaDomainRepository rendaDomainRepository;
    private final UsuarioDomainRepository usuarioDomainRepository;
    private final CategoriaMovimentoDomainRepository categoriaMovimentoDomainRepository;

    private final ApplicationEventPublisher publisher;

    @Override
    public UUID handle(RegistrarRenda cmd) {
        var usuario = usuarioDomainRepository.findById(cmd.getUsuario()).get();
        var categoria = categoriaMovimentoDomainRepository.findById(cmd.getCategoria()).get();

        var renda = Renda.builder()
                .categoriaMovimento(categoria)
                .usuario(usuario)
                .valor(cmd.getValor())
                .nome(cmd.getNome())
                .data(LocalDateTime.now())
                .build();
        this.rendaDomainRepository.save(renda);

        publisher.publishEvent(RendaRegistrada.from(renda));

        return renda.getId();
    }

    @Override
    public void on(RendaRegistrada rendaRegistrada) {

    }
}
