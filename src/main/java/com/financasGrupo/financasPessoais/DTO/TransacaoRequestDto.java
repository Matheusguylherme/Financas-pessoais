package com.financasGrupo.financasPessoais.DTO;

import com.financasGrupo.financasPessoais.model.TipoTransacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TransacaoRequestDto(

        String descricao,

        @NotNull(message = "O valor é obrigatório")
        Double valor,

        @NotNull(message = "O tipo é obrigatório")
        TipoTransacao tipo,

        @NotNull(message = "A data é obrigatória")
        LocalDateTime data,

        @NotNull(message = "O ID da categoria é obrigatório")
        Long categoriaId

) {}

