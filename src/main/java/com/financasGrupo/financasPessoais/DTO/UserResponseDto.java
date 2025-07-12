package com.financasGrupo.financasPessoais.DTO;

import com.financasGrupo.financasPessoais.model.Usuario;

public record UserResponseDto(

        Long id,
        String nome,
        String email
) {
    public UserResponseDto (Usuario entity) {
        this(entity.getId(), entity.getUsername(), entity.getEmail());
    }
}
