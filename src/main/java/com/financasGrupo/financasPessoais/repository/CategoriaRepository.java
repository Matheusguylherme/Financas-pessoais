package com.financasGrupo.financasPessoais.repository;

import java.util.Optional;
import com.financasGrupo.financasPessoais.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    Optional<Categoria> findByNome(String nome);
}
