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

   private Long id;
   private String logradluro;
   private String cep;
   private Integer numero;
   private String cidade;
   private boolean isPrincipal;
}
