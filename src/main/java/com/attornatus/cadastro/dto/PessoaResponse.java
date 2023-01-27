package com.attornatus.cadastro.dto;

import com.attornatus.cadastro.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaResponse {

    Long id;
    String nome;
    LocalDate dataNascimento;
    List<Endereco> endereco;

}
