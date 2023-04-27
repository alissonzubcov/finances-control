package br.com.zubcovsoft.financas.domain.categoriamovimento.repository;

import br.com.zubcovsoft.financas.domain.categoriamovimento.model.CategoriaMovimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoriaMovimentoDomainRepository extends JpaRepository<CategoriaMovimento, UUID> {

        @Query(value = "SELECT * FROM categoria_movimento", nativeQuery = true)
        List<CategoriaMovimento> getAll();

        @Query(value = "SELECT * FROM categoria_movimento WHERE id = :id", nativeQuery = true)
        CategoriaMovimento getById(UUID id);



}
