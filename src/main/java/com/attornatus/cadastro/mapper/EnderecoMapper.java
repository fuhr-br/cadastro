package com.attornatus.cadastro.mapper;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.dto.request.EnderecoRequest;
import com.attornatus.cadastro.dto.response.EnderecoResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public abstract class EnderecoMapper {

    public static Endereco toEndereco(EnderecoRequest dto){
        return  Endereco.builder()
                .logradluro(dto.getLogradluro())
                .cep(dto.getCep())
                .cidade(dto.getCidade())
                .numero(dto.getNumero()).build();
    }

    public static List<Endereco> toEnderecos(List<EnderecoRequest> lista){

      return   lista.stream().map((enderecoDTO) -> toEndereco(enderecoDTO)).toList();

    }

    public static List<EnderecoResponse> toEnderecosResponse(List<Endereco> endereco){
        return endereco.stream().map((dto)->
                EnderecoResponse.builder()
                        .id(dto.getId())
                        .logradluro(dto.getLogradluro())
                        .numero(dto.getNumero())
                        .cep(dto.getCep())
                        .cidade(dto.getCidade())
                .build() ).toList();
    }


}
