package br.com.cotiinformatica.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.components.MessageProducerComponent;
import br.com.cotiinformatica.dtos.PessoaRequestDto;
import br.com.cotiinformatica.dtos.PessoaResponseDto;
import br.com.cotiinformatica.entities.Pessoa;
import br.com.cotiinformatica.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired PessoaRepository pessoaRepository;
	@Autowired MessageProducerComponent messageProducerComponent;
	
	public PessoaResponseDto cadastrar(PessoaRequestDto request) {

		var pessoa = new Pessoa();
		
		pessoa.setId(UUID.randomUUID());
		pessoa.setNome(request.getNome());
		pessoa.setEmail(request.getEmail());
		pessoa.setTelefone(request.getTelefone());
		
		pessoaRepository.save(pessoa);
		
		try {
			messageProducerComponent.send(pessoa);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		var response = new PessoaResponseDto();
		
		response.setId(pessoa.getId());
		response.setNome(pessoa.getNome());
		response.setEmail(pessoa.getEmail());
		response.setTelefone(pessoa.getTelefone());
		response.setDataHoraCadastro(LocalDateTime.now());
		
		return response;
	}
}
