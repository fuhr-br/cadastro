package com.attornatus.cadastro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoResponse {

    Long id;
    String logradluro;
    String cep;
    Integer numero;
    String cidade;
}
