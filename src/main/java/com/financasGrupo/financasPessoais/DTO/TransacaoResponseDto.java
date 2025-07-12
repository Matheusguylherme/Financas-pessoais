package com.financasGrupo.financasPessoais.DTO;

import com.financasGrupo.financasPessoais.model.TipoTransacao;
import com.financasGrupo.financasPessoais.model.Transacao;

import java.time.LocalDateTime;

public record TransacaoResponseDto(
    Long id,
    String descricao,
    Double valor,
    TipoTransacao tipo,
    LocalDateTime data,
    String categoriaNome
    
) {
    public TransacaoResponseDto (Transacao entity) {
        this(
            entity.getId(),
            entity.getDescricao(),
            entity.getValor(),
            entity.getTipo(),
            entity.getData(),
            entity.getCategoria().getNome()
        );
    }
}
