package com.talissonmelo.entidades.exception;

public class EntidadeNaoEncontrada extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontrada(String entidade, Long id) {
		super(entidade + " de ID: " + id + ", não encontrado.");
	}
}