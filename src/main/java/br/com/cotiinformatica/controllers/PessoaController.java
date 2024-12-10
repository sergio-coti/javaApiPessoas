package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.PessoaRequestDto;
import br.com.cotiinformatica.dtos.PessoaResponseDto;
import br.com.cotiinformatica.services.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

	@Autowired PessoaService pessoaService;
	
	@PostMapping
	public PessoaResponseDto post(@RequestBody PessoaRequestDto dto) {
		return pessoaService.cadastrar(dto);
	}
}
