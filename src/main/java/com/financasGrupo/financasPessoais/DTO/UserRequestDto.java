package com.financasGrupo.financasPessoais.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDto(

        @NotBlank (message = "Digite o nome de usuário")
        String nome,

        @NotBlank
        @Email(message = "Digite seu e-mail")
        String email,

        @NotBlank
        @Size (min = 8, message = "A senha deve ter pelo menos 8 caracteres")
        String senha
) { }
