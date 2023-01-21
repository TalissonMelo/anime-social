package com.talissonmelo.entidades.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class UsuarioDto {

	@NotBlank(message = "Nome e obrigatório!")
	@Length(max = 80, message = "O nome deve ter no máximo {max} caracteres")
	private String nome;

	@Length(max = 80, message = "O e-mail deve ter no máximo {max} caracteres")
	@NotBlank(message = "E-mail e obrigatório!.")
	@Email(message = "E-mail invalido!")
	private String email;

	@Length(max = 80, message = "A senha deve ter no máximo {max} caracteres.")
	@NotBlank(message = "Senha e obrigatório!")
	private String senha;

	public UsuarioDto() {
	}

	public UsuarioDto(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
