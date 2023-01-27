package com.attornatus.cadastro.mapper;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.domain.Pessoa;
import com.attornatus.cadastro.dto.PessoaRequest;
import com.attornatus.cadastro.dto.PessoaResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public abstract class PessoaMapper {
    public static Pessoa toPessoa(PessoaRequest dto, List<Endereco> enderecos){
        return Pessoa.builder()
                .nome(dto.getNome())
                .dataNascimento(dto.getDataNascimento())
                .endereco(enderecos)
                .build();
    }

    public static PessoaResponse toPessoaResponse(Pessoa pessoa){
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .dataNascimento(pessoa.getDataNascimento())
                .endereco(pessoa.getEndereco())
                .build();
    }
}
