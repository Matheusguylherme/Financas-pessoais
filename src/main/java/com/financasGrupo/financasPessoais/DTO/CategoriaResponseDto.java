package com.financasGrupo.financasPessoais.DTO;

import com.financasGrupo.financasPessoais.model.Categoria;

public record CategoriaResponseDto(
        Long id,
        String nome
) {
    public CategoriaResponseDto (Categoria entity) {
        this(entity.getId(), entity.getNome());
    }
}
