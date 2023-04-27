package br.com.zubcovsoft.financas.domain.renda.repository;

import br.com.zubcovsoft.financas.domain.renda.model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RendaDomainRepository extends JpaRepository<Renda, UUID> {

    @Query(value = "SELECT * FROM renda", nativeQuery = true)
    List<Renda> getAll();


    default Renda get(UUID id){
        return getOneById(id).orElseThrow(this::notFound);
    }

    @Query(value = "SELECT * FROM renda where id = :id", nativeQuery = true )
    Optional<Renda> getOneById(UUID id);


    default RendaIdNaoEncontradaException notFound(){
        return new RendaIdNaoEncontradaException();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    class RendaIdNaoEncontradaException extends RuntimeException{

    }


}
