package com.talissonmelo.entidade;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date data;
	private String titulo;
	private String texto;
	private Usuario usuario;

	public Postagem() {
	}

	public Postagem(String id, Date data, String titulo, String texto, Usuario usuario) {
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
