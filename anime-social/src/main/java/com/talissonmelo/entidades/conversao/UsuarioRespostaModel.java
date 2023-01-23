package com.talissonmelo.entidades.conversao;

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
}
