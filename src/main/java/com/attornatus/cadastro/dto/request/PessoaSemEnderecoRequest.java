package com.attornatus.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Data
public class PessoaSemEnderecoRequest {

    Long id;

    @Size(min=4, max = 70, message = "Campo nome Ultrapassou o limite de caracteres, max 70")
    String nome;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(description = "Data nascimento da pessoa", example = "1986-03-30", required = true)
    LocalDate dataNascimento;
}
