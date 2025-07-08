package com.financasGrupo.financasPessoais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financasGrupo.financasPessoais.model.Transacao;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
  
}
