package com.attornatus.cadastro.service;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.domain.Pessoa;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.infra.PessoaRepository;
import com.attornatus.cadastro.stubs.EnderecoStub;
import com.attornatus.cadastro.stubs.PessoaRequestStub;
import com.attornatus.cadastro.stubs.PessoaStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

}