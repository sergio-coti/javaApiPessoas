package br.com.cotiinformatica.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class PessoaResponseDto {

	private UUID id;
	private String nome;
	private String email;
	private String telefone;
	private LocalDateTime dataHoraCadastro;
}
