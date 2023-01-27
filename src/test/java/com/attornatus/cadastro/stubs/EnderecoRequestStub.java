package com.attornatus.cadastro.stubs;

import com.attornatus.cadastro.dto.request.EnderecoRequest;

public interface EnderecoRequestStub {

    static EnderecoRequest construir(){
        return EnderecoRequest.builder()
                .logradluro("Rua das Marias")
                .cep("90050-230")
                .numero(234)
                .cidade("João Pessoa")
                .build();
    }
}
