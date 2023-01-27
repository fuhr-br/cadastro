package com.attornatus.cadastro.stubs;

import com.attornatus.cadastro.dto.request.PessoaRequest;

import java.time.LocalDate;
import java.util.List;

public interface PessoaRequestStub {

    static PessoaRequest construir(){
     return PessoaRequest.builder()
                .nome("Anderson Fuhr")
                .dataNascimento(LocalDate.of(1980, 1, 8))
                .build();

    }

    static PessoaRequest construirParaPersistir(){
        return PessoaRequest.builder()
                .nome("Anderson Fuhr")
                .dataNascimento(LocalDate.of(1980, 1, 8))
                .enderecos(List.of(EnderecoRequestStub.construir()))
                .build();

    }


}
