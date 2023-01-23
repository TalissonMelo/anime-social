package com.talissonmelo.servico;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.conversao.UsuarioModel;
import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;

	@Autowired
	private UsuarioModel usuarioModel;

	@Transactional
	public Usuario salvar(UsuarioDto dto) {
		Usuario usuario = this.usuarioModel.paraUsuario(dto);
		usuario.setNumero(this.repositorio.numeroMaximo());
		return repositorio.save(usuario);
	}
}
