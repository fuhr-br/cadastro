package com.attornatus.cadastro.service;

import com.attornatus.cadastro.domain.Endereco;
import com.attornatus.cadastro.domain.Pessoa;
import com.attornatus.cadastro.dto.request.EnderecoRequest;
import com.attornatus.cadastro.dto.request.PessoaRequest;
import com.attornatus.cadastro.dto.response.PessoaResponse;
import com.attornatus.cadastro.infra.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import static com.attornatus.cadastro.mapper.EnderecoMapper.toEnderecos;
import static com.attornatus.cadastro.mapper.PessoaMapper.toPessoa;
import static com.attornatus.cadastro.mapper.PessoaMapper.toPessoaResponse;

@Service
public class PessoaService {

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


}
