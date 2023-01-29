package com.attornatus.cadastro.stubs.pessoa;

import com.attornatus.cadastro.dto.request.PessoaSemEnderecoRequest;

import java.time.LocalDate;

public interface PessoaSemEnderecoRequestStub {

    static PessoaSemEnderecoRequest construir(){
        return PessoaSemEnderecoRequest.builder()
                .id(10L)
                .dataNascimento(LocalDate.of(1986, 1, 8))
                .nome("Anderson Fuhr Souza")
                .build();
    }
}

