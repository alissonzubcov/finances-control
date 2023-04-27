package br.com.zubcovsoft.financas.adapter.in.api;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import br.com.zubcovsoft.financas.domain.renda.model.RendaFilter;
import br.com.zubcovsoft.financas.domain.renda.projection.RendaDTO;
import br.com.zubcovsoft.financas.domain.renda.service.BuscarRendaAppService;
import br.com.zubcovsoft.financas.domain.renda.usecase.DeletarRendaUseCase;
import br.com.zubcovsoft.financas.domain.renda.usecase.RegistrarRendaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.zubcovsoft.financas.domain.renda.usecase.RegistrarRendaUseCase.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "api/v1/renda")
@RequiredArgsConstructor
public class RendaController {

    private final BuscarRendaAppService buscarRendaAppService;

    private final RegistrarRendaUseCase registrarRendaUseCase;

    private final DeletarRendaUseCase deletarRendaUseCase;


    @GetMapping
    public ResponseEntity<List<RendaDTO>> getAll(RendaFilter rendaFilter) {
        return ResponseEntity.ok(buscarRendaAppService.getAll(rendaFilter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RendaDTO> getById(@PathVariable UUID id) {
        var categoria = buscarRendaAppService.getById(id);
        return ResponseEntity.ok(categoria);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody RegistrarRenda cmd) {
        var renda = registrarRendaUseCase.handle(cmd);
        return ResponseEntity.created(fromCurrentRequest().path("/").path(renda.toString()).build().toUri()).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        deletarRendaUseCase.handle(id);
    }

}
