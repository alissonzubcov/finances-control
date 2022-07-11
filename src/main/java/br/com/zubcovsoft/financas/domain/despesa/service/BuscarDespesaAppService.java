package br.com.zubcovsoft.financas.domain.despesa.service;

import br.com.zubcovsoft.financas.domain.despesa.model.DespesaFiltro;
import br.com.zubcovsoft.financas.domain.despesa.projection.DespesaDTO;
import br.com.zubcovsoft.financas.domain.despesa.repository.DespesaDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class BuscarDespesaAppService {

    private final DespesaDomainRepository despesaDomainRepository;

    public DespesaDTO getById(UUID id){
        return DespesaDTO.from(despesaDomainRepository.get(id));
    }

    public List<DespesaDTO> getAll(){
        return despesaDomainRepository.getAll().stream().map(DespesaDTO::from).collect(Collectors.toList());
    }

}
