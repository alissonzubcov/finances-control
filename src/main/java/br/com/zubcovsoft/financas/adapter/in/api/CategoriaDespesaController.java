package br.com.zubcovsoft.financas.adapter.in.api;

import br.com.zubcovsoft.financas.domain.categoriadespesa.model.CategoriaDespesa;
import br.com.zubcovsoft.financas.domain.categoriadespesa.repository.CategoriaDespesaDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/categoria-despesa")
public class CategoriaDespesaController {

    @Autowired
    private CategoriaDespesaDomainRepository categoriaDespesaDomainRepository;

    @GetMapping
    public ResponseEntity<List<CategoriaDespesa>> getAllCategoriasDespesa(){
        return ResponseEntity.ok( categoriaDespesaDomainRepository.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDespesa> getCategoriaDespesaById(@PathVariable UUID id){
        var categoria = categoriaDespesaDomainRepository.getById(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

}
