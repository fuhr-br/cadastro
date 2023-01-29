package com.attornatus.cadastro.stubs.endereco;

import com.attornatus.cadastro.domain.Endereco;

import java.util.List;

public interface EnderecoStub {

    static Endereco construir(){
       return Endereco.builder()
               .id(1L)
               .logradluro("Rua das Marias")
               .numero(234)
               .cidade("João Pessoa")
               .cep("90050-230")
               .build();
    }

    static List<Endereco> construirLista(){
        return List.of(construir(), construir());
    }
}
