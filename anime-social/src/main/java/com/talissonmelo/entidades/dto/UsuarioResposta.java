package com.talissonmelo.entidades.dto;

public class UsuarioResposta {

	private Long id;
	private String nome;
	private String email;
	private Integer numero;

	public UsuarioResposta() {
	}

	public UsuarioResposta(Long id, String nome, String email, Integer numero) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
