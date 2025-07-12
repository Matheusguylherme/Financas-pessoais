package com.financasGrupo.financasPessoais.DTO;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDto(

        @NotBlank
        String nome,

        String descricao
) {
}
