package br.com.zubcovsoft.financas.domain.categoriadespesa.repository;

import br.com.zubcovsoft.financas.domain.categoriadespesa.model.CategoriaDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaDespesaDomainRepository extends JpaRepository<CategoriaDespesa, UUID> {

        @Query(value = "SELECT * FROM categoria_despesa", nativeQuery = true)
        List<CategoriaDespesa> getAll();


        @Query(value = "SELECT * FROM categoria_despesa WHERE id = :id", nativeQuery = true)
        CategoriaDespesa getById(UUID id);

}
