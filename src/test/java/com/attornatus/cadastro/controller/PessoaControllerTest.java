package com.attornatus.cadastro.controller;

import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.stubs.EnderecoResponseStub;
import com.attornatus.cadastro.stubs.PessoaRequestStub;
import com.attornatus.cadastro.stubs.PessoaResponseStub;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.attornatus.cadastro.SqlProvider.resetaDB;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();
    private String retornoComoJson;
    private String envioComoJSON;

    PessoaRequest pessoaRequest;
    PessoaResponse pessoaResponse;
    @BeforeEach
    public void inicializar() throws JsonProcessingException {
         pessoaRequest = PessoaRequestStub.construirParaPersistir();
         pessoaResponse = PessoaResponseStub.construir();
         pessoaResponse.setEndereco(List.of(EnderecoResponseStub.construir()));
        pessoaResponse.setId(1L);

        retornoComoJson = mapper.writeValueAsString(pessoaResponse);
        envioComoJSON = mapper.writeValueAsString(pessoaRequest);
    }

    @Test
    @DisplayName("Teste POST/SUCESSO salvar uma Pessoa")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = resetaDB)
    void salvar() throws Exception {

        mockMvc.perform(post("/cadastro/pessoa")
                        .content(envioComoJSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(retornoComoJson))
                .andExpect(status().isCreated());

    }
}