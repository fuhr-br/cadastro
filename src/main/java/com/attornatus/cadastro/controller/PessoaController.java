package com.attornatus.cadastro.controller;


import com.attornatus.cadastro.dto.request.EnderecoRequest;
import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.request.PessoaSemEnderecoRequest;
import com.attornatus.cadastro.dto.response.EnderecoResponse;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RequestMapping("/cadastro/pessoa")
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping()
    public ResponseEntity<PessoaResponse> salvar(@RequestBody @Valid PessoaRequest pessoaRequest) {
        return new ResponseEntity<>(pessoaService.salvarPessoa(pessoaRequest), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<PessoaResponse> atualizar(@RequestBody @Valid PessoaSemEnderecoRequest pessoaRequest){
        return new ResponseEntity<>(pessoaService.atualizar(pessoaRequest),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(pessoaService.buscaPorId(id),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PessoaResponse>> buscarTodos(){
        return new ResponseEntity<>(pessoaService.buscarTodos(),HttpStatus.OK);
    }

    @PostMapping("/{id}/endereco")
    public ResponseEntity<PessoaResponse> adicionarEndereco(
            @PathVariable Long id,
            @RequestBody @Valid EnderecoRequest enderecoRequest) {
        return new ResponseEntity<>(pessoaService.salvarEndereco(enderecoRequest, id), HttpStatus.CREATED);
    }

    @PutMapping("/{idPessoa}/endereco/{idEndereco}")
    public ResponseEntity<EnderecoResponse> setarEnderecoPrincipal(
            @PathVariable Long idPessoa,
            @PathVariable Long idEndereco

    ){
        return new ResponseEntity<>(pessoaService.setarEnderecoPrincipal(idPessoa,idEndereco), HttpStatus.OK);
    }
}
