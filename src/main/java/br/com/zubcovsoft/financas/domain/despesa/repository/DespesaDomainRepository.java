package br.com.zubcovsoft.financas.domain.despesa.repository;

import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DespesaDomainRepository extends JpaRepository<Despesa, UUID> {

    @Query(value = "SELECT * FROM despesa", nativeQuery = true)
    List<Despesa> getAll();


    default Despesa get(UUID id){
        return getOneById(id).orElseThrow(this::notFound);
    }

    @Query(value = "SELECT * FROM despesa where id = :id", nativeQuery = true )
    Optional<Despesa> getOneById(UUID id);


    default DespesaIdNaoEncontradaException notFound(){
        return new DespesaIdNaoEncontradaException();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    class DespesaIdNaoEncontradaException extends RuntimeException{

    }
}
