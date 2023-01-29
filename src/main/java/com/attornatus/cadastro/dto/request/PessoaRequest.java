package com.attornatus.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class PessoaRequest {

    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    @Size(min=4, max = 70, message = "Campo nome Ultrapassou o limite de caracteres, max 70")
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotNull(message = "Campo Datas inválido")
    @Schema(description = "Data nascimento da pessoa", example = "1986-03-30", required = true)
    private LocalDate dataNascimento;

    private List<@Valid EnderecoRequest> enderecos;
}
