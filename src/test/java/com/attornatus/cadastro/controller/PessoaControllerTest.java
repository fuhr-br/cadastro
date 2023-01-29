package com.attornatus.cadastro.controller;

import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.request.PessoaSemEnderecoRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.stubs.endereco.EnderecoResponseStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaRequestStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaResponseStub;
import com.attornatus.cadastro.stubs.pessoa.PessoaSemEnderecoRequestStub;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    private String envioComoJSONUpdate;

    PessoaRequest pessoaRequest;
    PessoaResponse pessoaResponse;
    PessoaSemEnderecoRequest pessoaRequestSemEndereco;

    @BeforeEach
    public void inicializar() throws JsonProcessingException {
         pessoaRequest = PessoaRequestStub.construirParaPersistir();
         pessoaRequestSemEndereco = PessoaSemEnderecoRequestStub.construir();
         pessoaResponse = PessoaResponseStub.construir();
         pessoaResponse.setEndereco(List.of(EnderecoResponseStub.construir()));
         pessoaResponse.setId(1L);

        retornoComoJson = mapper.writeValueAsString(pessoaResponse);
        envioComoJSON = mapper.writeValueAsString(pessoaRequest);
        envioComoJSONUpdate = mapper.writeValueAsString(pessoaRequestSemEndereco);
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

    @DisplayName("Teste GET/Error")
    @Test
    public void testeGetIdInvalido() throws Exception {
        mockMvc.perform(get("/cadastro/pessoa/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    @DisplayName("Teste GET/BuscarTodos")
    @Test
    public void testeBuscarTodos() throws Exception {
        mockMvc.perform(get("/cadastro/pessoa")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @DisplayName("Teste PUT/Error")
    @Test
    public void testePutIdInvalido() throws Exception {
        mockMvc.perform(put("/cadastro/pessoa")
                        .content(envioComoJSONUpdate)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }




}