package com.attornatus.cadastro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class PessoaRequest {

    String nome;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Campo Datas inválido")
    @Schema(description = "Data nascimento da pessoa", example = "1986-03-30", required = true)
    LocalDate dataNascimento;

    List<EnderecoRequest> enderecos;

}
