package com.talissonmelo.entidades.conversao;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.dto.UsuarioResposta;

@Component
public class UsuarioRespostaModel {

	@Autowired
	private ModelMapper mapper;

	public UsuarioResposta paraUsuarioResposta(Usuario usuario) {
		return mapper.map(usuario, UsuarioResposta.class);
	}
	
	public List<UsuarioResposta> paraUsuarioRespostas(List<Usuario> usuarios) {
		return usuarios.stream().map((usuario) -> this.paraUsuarioResposta(usuario)).collect(Collectors.toList());
	}
}
