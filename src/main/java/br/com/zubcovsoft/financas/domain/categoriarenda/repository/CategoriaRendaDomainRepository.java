package br.com.zubcovsoft.financas.domain.categoriarenda.repository;

import br.com.zubcovsoft.financas.domain.categoriadespesa.model.CategoriaDespesa;
import br.com.zubcovsoft.financas.domain.categoriarenda.model.CategoriaRenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoriaRendaDomainRepository extends JpaRepository<CategoriaRenda, UUID> {

        @Query(value = "SELECT * FROM categoria_renda", nativeQuery = true)
        List<CategoriaRenda> getAll();

        @Query(value = "SELECT * FROM categoria_renda WHERE id = :id", nativeQuery = true)
        CategoriaRenda getById(UUID id);



}
