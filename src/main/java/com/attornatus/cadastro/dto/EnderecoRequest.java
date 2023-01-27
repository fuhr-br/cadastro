package com.attornatus.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder
public class EnderecoRequest {

    @NotBlank
    String logradluro;

    @NotBlank
    String CEP;

    @NotBlank
    Integer numero;

    @NotBlank
    String cidade;
}
