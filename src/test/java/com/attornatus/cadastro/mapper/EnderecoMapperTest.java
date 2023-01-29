package com.attornatus.cadastro.mapper;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.dto.request.EnderecoRequest;
import com.attornatus.cadastro.stubs.endereco.EnderecoRequestStub;
import com.attornatus.cadastro.stubs.endereco.EnderecoStub;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoMapperTest {

  private final Endereco endereco = EnderecoStub.construir();
  private final EnderecoRequest enderecoRequest = EnderecoRequestStub.construir();


   @Test
   @DisplayName("Deve converter EnderecoRequest para Endereco")
   void toEndereco(){
        Endereco retorno = EnderecoMapper.toEndereco(enderecoRequest);

       assertEquals(endereco.getCep(), retorno.getCep());
       assertEquals(endereco.getCidade(), retorno.getCidade());
       assertEquals(endereco.getLogradluro(), retorno.getLogradluro());
       assertEquals(endereco.getNumero(), retorno.getNumero());
   }
    @Test
    @DisplayName("Deve converter uma lista de EnderecoRequest para lista de Endereco")
    void toEnderecos(){
       List<Endereco> retornos = EnderecoMapper.toEnderecos(List.of(enderecoRequest, enderecoRequest));
       assertEquals(retornos.get(0).getCep(),enderecoRequest.getCep());

        assertEquals(endereco.getCep(), retornos.get(0).getCep());
        assertEquals(endereco.getCidade(), retornos.get(0).getCidade());
        assertEquals(endereco.getLogradluro(), retornos.get(0).getLogradluro());
        assertEquals(endereco.getNumero(), retornos.get(0).getNumero());
        assertEquals(2, retornos.size());
    }

}