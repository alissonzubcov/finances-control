package br.com.zubcovsoft.financas.adapter.in.api;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import br.com.zubcovsoft.financas.domain.despesa.model.DespesaFilter;
import br.com.zubcovsoft.financas.domain.despesa.projection.DespesaDTO;
import br.com.zubcovsoft.financas.domain.despesa.service.BuscarDespesaAppService;
import br.com.zubcovsoft.financas.domain.despesa.usecase.DeletarDespesaUseCase;
import br.com.zubcovsoft.financas.domain.despesa.usecase.RegistrarDespesaUseCase;
import br.com.zubcovsoft.financas.domain.despesa.usecase.RegistrarDespesaUseCase.RegistrarDespesa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "api/v1/despesa")
@RequiredArgsConstructor
public class DespesaController {

    private final BuscarDespesaAppService buscarDespesaAppService;

    private final RegistrarDespesaUseCase registrarDespesaUseCase;

    private final DeletarDespesaUseCase deletarDespesaUseCase;


    @GetMapping
    public ResponseEntity<List<DespesaDTO>> getAll(DespesaFilter despesaFilter) {
        return ResponseEntity.ok(buscarDespesaAppService.getAll(despesaFilter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDTO> getById(@PathVariable UUID id) {
        var categoria = buscarDespesaAppService.getById(id);
        return ResponseEntity.ok(categoria);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody RegistrarDespesa cmd) {
        var despesa = registrarDespesaUseCase.handle(cmd);
        return ResponseEntity.created(fromCurrentRequest().path("/").path(despesa.toString()).build().toUri()).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        deletarDespesaUseCase.handle(id);
    }

}
