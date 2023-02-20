package com.talissonmelo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.entidade.Postagem;
import com.talissonmelo.repositorio.PostagemRepositorio;

@Service
public class PostagemServico {
	
	@Autowired
	private PostagemRepositorio repositorio;

	public List<Postagem> listar() {
		return repositorio.findAll();
	}
}
