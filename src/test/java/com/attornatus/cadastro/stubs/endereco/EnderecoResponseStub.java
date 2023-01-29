package com.attornatus.cadastro.stubs.endereco;

import com.attornatus.cadastro.dto.response.EnderecoResponse;

import java.util.List;

public interface EnderecoResponseStub {

    static EnderecoResponse construir(){
        return EnderecoResponse.builder()
                .id(1L)
                .logradluro("Rua das Marias")
                .numero(234)
                .cidade("João Pessoa")
                .cep("90050-230")
                .build();
    }

    static List<EnderecoResponse> criarLista(){
        return List.of(construir(), construir());
    }
}
