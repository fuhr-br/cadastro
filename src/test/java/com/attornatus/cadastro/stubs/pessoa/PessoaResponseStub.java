package com.attornatus.cadastro.stubs.pessoa;

import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.stubs.endereco.EnderecoResponseStub;

import java.time.LocalDate;

public interface PessoaResponseStub {

    static PessoaResponse construir(){
       return PessoaResponse.builder()
               .id(10L)
               .nome("Anderson Fuhr")
               .dataNascimento(LocalDate.of(1980, 1, 8))
               .endereco(EnderecoResponseStub.criarLista())
               .build();
    }
}
