package br.com.cotiinformatica.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Pessoa {

	@Id
	private UUID id;
	private String nome;
	private String email;
	private String telefone;
}
