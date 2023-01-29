package com.attornatus.cadastro.service;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.domain.Pessoa;
import com.attornatus.cadastro.dto.request.EnderecoRequest;
import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.request.PessoaSemEnderecoRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.exception.NotFoundException;
import com.attornatus.cadastro.infra.PessoaRepository;
import com.attornatus.cadastro.mapper.EnderecoMapper;
import com.attornatus.cadastro.mapper.PessoaMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import static com.attornatus.cadastro.mapper.EnderecoMapper.toEnderecos;
import static com.attornatus.cadastro.mapper.PessoaMapper.toPessoa;
import static com.attornatus.cadastro.mapper.PessoaMapper.toPessoaResponse;

@Service
public class PessoaService {

    private final String MENSAGEM_EXCEPTION_NOT_FOUND = "Pessoa não encontrada!";

    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;

    public PessoaService(PessoaRepository pessoaRepository,
                         EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoService = enderecoService;
    }

    @Transactional
    public PessoaResponse salvarPessoa(PessoaRequest pessoaRequest){

        final List<Endereco> enderecos = this.salvarEnderecos(pessoaRequest.getEnderecos());
        final Pessoa pessoa = toPessoa(pessoaRequest, enderecos);

        return toPessoaResponse(pessoaRepository.save(pessoa));
    }

    private  List<Endereco> salvarEnderecos(List<EnderecoRequest> dtos){
      List<Endereco> enderecos = toEnderecos(dtos);
      return enderecos.stream().map(enderecoService::save).toList();
    }


    public PessoaResponse buscaPorId(Long id) {
        return toPessoaResponse(pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MENSAGEM_EXCEPTION_NOT_FOUND)));
    }

    @Transactional
    public PessoaResponse atualizar(PessoaSemEnderecoRequest pessoaRequest) {
        PessoaResponse pessoa = buscaPorId(pessoaRequest.getId());

        return toPessoaResponse(pessoaRepository.save(Pessoa.builder()
                .id(pessoa.getId())
                .nome(pessoaRequest.getNome())
                .dataNascimento(pessoaRequest.getDataNascimento())
                .endereco(EnderecoMapper.toEnderecosOfResponses(pessoa.getEndereco()))
                .build()));
    }

    public List<PessoaResponse> buscarTodos(){
        return pessoaRepository.findAll().stream().map(PessoaMapper::toPessoaResponse).toList();
    }


}
