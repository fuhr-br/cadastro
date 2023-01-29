package com.attornatus.cadastro.service;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.domain.Pessoa;
import com.attornatus.cadastro.dto.request.PessoaSemEnderecoRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.exception.NotFoundException;
import com.attornatus.cadastro.infra.PessoaRepository;
import com.attornatus.cadastro.stubs.endereco.EnderecoStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaRequestStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaSemEnderecoRequestStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PessoaServiceTest {
    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepositoryMock;

    @Mock
    private EnderecoService enderecoServiceMock;

    private final Pessoa pessoa = PessoaStub.construir();
    private final Endereco endereco = EnderecoStub.construir();
    private final String MENSAGEM_EXCEPTION_NOT_FOUND = "Pessoa não encontrada!";

    @Test
    @DisplayName("Deve salvar uma Pessoa com Sucesso")
    void salvarPessoa() {
        when(enderecoServiceMock.save(endereco)).thenReturn(endereco);
        when(pessoaRepositoryMock.save(any(Pessoa.class))).thenReturn(pessoa);
        PessoaResponse pessoaResponse= pessoaService.salvarPessoa(PessoaRequestStub.construirParaPersistir());

        assertEquals(pessoa.getId(), pessoaResponse.getId());
        assertEquals(pessoa.getNome(), pessoaResponse.getNome());
        assertEquals(pessoa.getDataNascimento(), pessoaResponse.getDataNascimento());
    }

    @Test
    @DisplayName("Deve retornar exception  ao buscar uma pessoa com id inexistente")
    void buscaPorIdTesteError() {
        Throwable erro = assertThrows(NotFoundException.class,
                () -> pessoaService.buscaPorId(2L));
        assertEquals(MENSAGEM_EXCEPTION_NOT_FOUND, erro.getLocalizedMessage());
    }

    @Test
    @DisplayName("Deve atualizar uma Pessoa com sucesso")
    void atualizarTeste() {
        when(pessoaRepositoryMock.findById(any(Long.class))).thenReturn(Optional.of(pessoa));

        Pessoa pessoaUpdate = Pessoa.builder()
                .id(10L)
                .dataNascimento(LocalDate.of(1986, 1, 8))
                .nome("Anderson Fuhr Souza")
                .endereco(EnderecoStub.construirLista())
                .build();

        when(pessoaRepositoryMock.save(any(Pessoa.class))).thenReturn(pessoaUpdate);

        PessoaSemEnderecoRequest pessoaSemEnderecoRequest = PessoaSemEnderecoRequestStub.construir();
        PessoaResponse pessoa = pessoaService.atualizar(pessoaSemEnderecoRequest);

        assertEquals(pessoa.getNome(), pessoaUpdate.getNome());
        assertEquals(pessoa.getDataNascimento(), pessoaUpdate.getDataNascimento());
    }

}