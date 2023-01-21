package com.talissonmelo.servico;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;

	@Transactional
	public Usuario salvar(UsuarioDto dto) {
		Usuario usuario = this.criarUsuario(dto);
		return repositorio.save(usuario);
	}

	private Usuario criarUsuario(UsuarioDto dto) {
		Usuario usuario = new Usuario();
		usuario.setNumero(this.repositorio.numeroMaximo());
		usuario.setEmail(dto.getEmail());
		usuario.setNome(dto.getNome());
		usuario.setSenha(dto.getSenha());
		return usuario;
	}
}
