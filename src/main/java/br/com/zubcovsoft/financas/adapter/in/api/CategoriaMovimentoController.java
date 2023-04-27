package br.com.zubcovsoft.financas.adapter.in.api;

import br.com.zubcovsoft.financas.domain.categoriamovimento.model.CategoriaMovimento;
import br.com.zubcovsoft.financas.domain.categoriamovimento.repository.CategoriaMovimentoDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/categoria-renda")
public class CategoriaMovimentoController {

    @Autowired
    private CategoriaMovimentoDomainRepository categoriaMovimentoDomainRepository;

    @GetMapping
    public ResponseEntity<List<CategoriaMovimento>> getAllCategoriasMovimento(){
        return ResponseEntity.ok( categoriaMovimentoDomainRepository.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaMovimento> getCategoriaMovimentoById(@PathVariable UUID id){
        var categoria = categoriaMovimentoDomainRepository.getById(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

}
