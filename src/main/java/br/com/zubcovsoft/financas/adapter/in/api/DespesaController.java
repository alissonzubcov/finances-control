package br.com.zubcovsoft.financas.adapter.in.api;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import br.com.zubcovsoft.financas.domain.despesa.repository.DespesaDomainRepository;
import br.com.zubcovsoft.financas.domain.despesa.usecase.RegistrarDespesaUseCase;
import br.com.zubcovsoft.financas.domain.despesa.usecase.RegistrarDespesaUseCase.RegistrarDespesa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "api/v1/despesa")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaDomainRepository despesaDomainRepository;

    private final RegistrarDespesaUseCase registrarDespesaUseCase;


    @GetMapping
    public ResponseEntity<List<Despesa>> getAll() {
        return ResponseEntity.ok(despesaDomainRepository.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> getById(@PathVariable UUID id) {
        var categoria = despesaDomainRepository.getById(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody RegistrarDespesa cmd, UriComponentsBuilder uriBuilder) {
        var despesa = registrarDespesaUseCase.handle(cmd);
//        URI uri = uriBuilder.path("/despesa/{id}").buildAndExpand(despesa.getId()).toUri();
//        return ResponseEntity.created(uri).body(despesaSalva);
        return ResponseEntity.created(fromCurrentRequest().path("/").path(despesa.toString()).build().toUri()).build();
    }

}
