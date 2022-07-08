package br.com.zubcovsoft.financas.domain.renda.repository;

import br.com.zubcovsoft.financas.domain.renda.model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RendaDomainRepository extends JpaRepository<Renda, UUID> {


}
