package com.attornatus.cadastro.mapper;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.dto.EnderecoRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public abstract class EnderecoMapper {

    public static Endereco toEndereco(EnderecoRequest dto){
        return  Endereco.builder()
                .logradluro(dto.getLogradluro())
                .CEP(dto.getCEP())
                .cidade(dto.getCidade())
                .numero(dto.getNumero()).build();
    }

    public static List<Endereco> toEnderecos(List<EnderecoRequest> lista){

      return   lista.stream().map((enderecoDTO) -> toEndereco(enderecoDTO)).toList();

    }


}
