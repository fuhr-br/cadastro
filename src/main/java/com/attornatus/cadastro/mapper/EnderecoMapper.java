package com.attornatus.cadastro.mapper;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.dto.request.EnderecoRequest;
import com.attornatus.cadastro.dto.response.EnderecoResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public interface EnderecoMapper {

     static Endereco toEndereco(EnderecoRequest dto){
        return  Endereco.builder()
                .logradluro(dto.getLogradluro())
                .cep(dto.getCep())
                .cidade(dto.getCidade())
                .numero(dto.getNumero()).build();
    }

    static Endereco toEnderecoOfResponse(EnderecoResponse dto){
        return  Endereco.builder()
                .logradluro(dto.getLogradluro())
                .cep(dto.getCep())
                .cidade(dto.getCidade())
                .numero(dto.getNumero())
                .isPrincipal(dto.isPrincipal())
                .build();
    }

    static EnderecoResponse toEnderecoResponse(Endereco endereco){
        return  EnderecoResponse.builder()
                .id(endereco.getId())
                .logradluro(endereco.getLogradluro())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .numero(endereco.getNumero())
                .isPrincipal(endereco.isPrincipal())
                .build();
    }

     static List<Endereco> toEnderecos(List<EnderecoRequest> lista){
        return   lista.stream().map(EnderecoMapper::toEndereco).toList();
    }

    static List<Endereco> toEnderecosOfResponses(List<EnderecoResponse> lista){
        return   lista.stream().map(EnderecoMapper::toEnderecoOfResponse).toList();
    }

     static List<EnderecoResponse> toEnderecosResponse(List<Endereco> endereco){
        return endereco.stream().map(dto->
                EnderecoResponse.builder()
                        .id(dto.getId())
                        .logradluro(dto.getLogradluro())
                        .numero(dto.getNumero())
                        .cep(dto.getCep())
                        .cidade(dto.getCidade())
                        .isPrincipal(dto.isPrincipal())
                .build() ).toList();
    }
}
