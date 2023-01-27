package com.attornatus.cadastro.service;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.infra.EnderecoRepository;
import com.attornatus.cadastro.stubs.EnderecoStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoRepository enderecoRepositoryMock;

    private final Endereco endereco = EnderecoStub.construir();

    @Test
    @DisplayName("Deve salvar um Endereco com Sucesso")
    void save() {
        when(enderecoRepositoryMock.save(endereco)).thenReturn(endereco);
        Endereco retorno = enderecoService.save(endereco);
        assertThat(endereco).isNotNull().isEqualTo(retorno);
    }
}