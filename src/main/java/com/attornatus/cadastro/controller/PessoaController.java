package com.attornatus.cadastro.controller;


import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.request.PessoaSemEnderecoRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RequestMapping("/cadastro")
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/pessoa")
    public ResponseEntity<PessoaResponse> salvar(@RequestBody @Valid PessoaRequest pessoaRequest) {
        return new ResponseEntity<>(pessoaService.salvarPessoa(pessoaRequest), HttpStatus.CREATED);
    }

    @PutMapping("/pessoa")
    public ResponseEntity<PessoaResponse> atualizar(@RequestBody @Valid PessoaSemEnderecoRequest pessoaRequest){
        return new ResponseEntity<>(pessoaService.atualizar(pessoaRequest),HttpStatus.OK);
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<PessoaResponse> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(pessoaService.buscaPorId(id),HttpStatus.OK);
    }

    @GetMapping("/pessoa")
    public ResponseEntity<List<PessoaResponse>> buscarTodos(){
        return new ResponseEntity<>(pessoaService.buscarTodos(),HttpStatus.OK);
    }

}
