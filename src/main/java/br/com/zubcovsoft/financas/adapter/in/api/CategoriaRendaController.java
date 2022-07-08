package br.com.zubcovsoft.financas.adapter.in.api;

import br.com.zubcovsoft.financas.domain.categoriarenda.model.CategoriaRenda;
import br.com.zubcovsoft.financas.domain.categoriarenda.repository.CategoriaRendaDomainRepository;
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
public class CategoriaRendaController {

    @Autowired
    private CategoriaRendaDomainRepository categoriaRendaDomainRepository;

    @GetMapping
    public ResponseEntity<List<CategoriaRenda>> getAllCategoriasRenda(){
        return ResponseEntity.ok( categoriaRendaDomainRepository.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaRenda> getCategoriaRendaById(@PathVariable UUID id){
        var categoria = categoriaRendaDomainRepository.getById(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

}
