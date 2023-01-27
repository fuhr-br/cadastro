package com.attornatus.cadastro.mapper;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.domain.Pessoa;
import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.attornatus.cadastro.mapper.EnderecoMapper.toEnderecosResponse;

@Component
@Lazy
public interface PessoaMapper {
     static Pessoa toPessoa(PessoaRequest dto, List<Endereco> enderecos){
        return Pessoa.builder()
                .nome(dto.getNome())
                .dataNascimento(dto.getDataNascimento())
                .endereco(enderecos)
                .build();
    }

     static PessoaResponse toPessoaResponse(Pessoa pessoa){
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .dataNascimento(pessoa.getDataNascimento())
                .endereco(toEnderecosResponse(pessoa.getEndereco()))
                .build();
    }
}
