package com.talissonmelo.servico;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.conversao.UsuarioModel;
import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.entidades.exception.EntidadeNaoEncontrada;
import com.talissonmelo.entidades.exception.RegraDeNegocioException;
import com.talissonmelo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;

	@Autowired
	private UsuarioModel usuarioModel;

	@Transactional
	public Usuario salvar(UsuarioDto dto) {
		this.validarEmail(dto.getEmail());
		Usuario usuario = this.usuarioModel.paraUsuario(dto);
		usuario.setNumero(this.repositorio.numeroMaximo());
		return repositorio.save(usuario);
	}

	public Usuario listarPorId(Long id) {
		return this.repositorio.findById(id).orElseThrow(() -> new EntidadeNaoEncontrada(Usuario.class.getSimpleName().toString(), id));
	}
	
	public List<Usuario> listar(){
		return this.repositorio.findAll();
	}

	private void validarEmail(String email) {
		boolean existe = this.repositorio.existsByEmail(email);
		if (existe) {
			throw new RegraDeNegocioException("Já existe um usuário cadastrado com este email!.");
		}
	}
}
