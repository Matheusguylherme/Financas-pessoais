package com.financasGrupo.financasPessoais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financasGrupo.financasPessoais.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
  Optional<Usuario> findByUsername(String username);
}
