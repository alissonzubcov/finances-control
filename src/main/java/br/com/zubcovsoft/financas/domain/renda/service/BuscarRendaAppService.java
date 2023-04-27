package br.com.zubcovsoft.financas.domain.renda.service;

import br.com.zubcovsoft.financas.domain.renda.model.RendaFilter;
import br.com.zubcovsoft.financas.domain.renda.projection.RendaDTO;
import br.com.zubcovsoft.financas.domain.renda.repository.RendaDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class BuscarRendaAppService {

    private final RendaDomainRepository rendaDomainRepository;

    public RendaDTO getById(UUID id){
        return RendaDTO.from(rendaDomainRepository.get(id));
    }

    public List<RendaDTO> getAll(RendaFilter rendaFilter){
        return rendaDomainRepository.getAll().stream().map(RendaDTO::from).collect(Collectors.toList());
    }

}
