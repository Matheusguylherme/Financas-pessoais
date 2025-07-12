package com.financasGrupo.financasPessoais.DTO;

import jakarta.validation.constraints.Email;


public record UserUpdateDto(
        String nome,
        @Email
        String email
) { }
