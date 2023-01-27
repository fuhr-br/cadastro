package com.attornatus.cadastro.stubs;

import com.attornatus.cadastro.domain.Pessoa;

import java.time.LocalDate;

public interface PessoaStub {
    static Pessoa construir(){
        return Pessoa.builder()
                .id(10L)
                .nome("Anderson Fuhr")
                .dataNascimento(LocalDate.of(1980,01, 8))
                .endereco(EnderecoStub.construirLista())
                .build();
    }
}
