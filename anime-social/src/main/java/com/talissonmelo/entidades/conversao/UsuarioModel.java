package com.talissonmelo.entidades.conversao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.dto.UsuarioDto;

@Component
public class UsuarioModel {

	@Autowired
	private ModelMapper mapper;

	public Usuario paraUsuario(UsuarioDto dto) {
		return mapper.map(dto, Usuario.class);
	}
}
