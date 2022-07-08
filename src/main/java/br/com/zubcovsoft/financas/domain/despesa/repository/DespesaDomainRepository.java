package br.com.zubcovsoft.financas.domain.despesa.repository;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DespesaDomainRepository extends JpaRepository<Despesa, UUID> {

    @Query(value = "SELECT * FROM despesa", nativeQuery = true)
    List<Despesa> getAll();


}
