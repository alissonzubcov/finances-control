package br.com.zubcovsoft.financas.domain.usuario.repository;

import br.com.zubcovsoft.financas.domain.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioDomainRepository extends JpaRepository<Usuario, UUID> {


}
