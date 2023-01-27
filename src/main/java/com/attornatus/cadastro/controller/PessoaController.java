package com.attornatus.cadastro.controller;


import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RequestMapping("/cadastro")
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/pessoa")
    public ResponseEntity<PessoaResponse> salvar(@RequestBody @Valid PessoaRequest autorRequest) {
        return new ResponseEntity<PessoaResponse>(pessoaService.salvarPessoa(autorRequest), HttpStatus.CREATED);
    }

}
