package br.com.zubcovsoft.financas.domain.despesa.service;

import br.com.zubcovsoft.financas.domain.categoriadespesa.repository.CategoriaDespesaDomainRepository;
import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import br.com.zubcovsoft.financas.domain.despesa.repository.DespesaDomainRepository;
import br.com.zubcovsoft.financas.domain.despesa.usecase.RegistrarDespesaUseCase;
import br.com.zubcovsoft.financas.domain.usuario.repository.UsuarioDomainRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    private final CategoriaDespesaDomainRepository categoriaDespesaDomainRepository;

    @Override
    public UUID handle(RegistrarDespesa cmd) {
        var usuario = usuarioDomainRepository.findById(cmd.getUsuario()).get();
        var categoria = categoriaDespesaDomainRepository.findById(cmd.getCategoria()).get();

        var despesa = Despesa.builder()
                .categoriaDespesa(categoria)
                .usuario(usuario)
                .parcela(cmd.getParcela())
                .parcelado(cmd.getParcelado())
                .valor(cmd.getValor())
                .data(LocalDateTime.now())
                .build();
        this.despesaDomainRepository.save(despesa);
        return despesa.getId();
    }

    @Override
    public void on(DespesaRegistrada despesaRegistrada) {

    }
}
