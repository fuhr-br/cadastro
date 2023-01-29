package com.attornatus.cadastro.mapper;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.domain.Pessoa;
import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.stubs.endereco.EnderecoStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaRequestStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaResponseStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaMapperTest {

    private final Pessoa pessoa = PessoaStub.construir();
    private final PessoaResponse pessoaResponse = PessoaResponseStub.construir();
    private final PessoaRequest pessoaRequest = PessoaRequestStub.construir();
    private final List<Endereco> endereco = EnderecoStub.construirLista();

    @Test
    @DisplayName("Deve testar a conversão de PessoaRequest para Pessoa")
    void toPessoa() {
       Pessoa retorno = PessoaMapper.toPessoa(pessoaRequest, endereco);

       assertEquals(pessoa.getDataNascimento(), retorno.getDataNascimento());
       assertEquals(pessoa.getEndereco(), retorno.getEndereco());
       assertEquals(pessoa.getNome(), retorno.getNome());
    }

    @Test
    @DisplayName("Deve testar a conversão de Pessoa para PessoaResponse")
    void toPessoaResponse() {
        PessoaResponse retorno = PessoaMapper.toPessoaResponse(pessoa);
        assertEquals(pessoaResponse, retorno);
    }
}