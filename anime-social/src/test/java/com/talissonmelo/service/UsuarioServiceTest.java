package com.talissonmelo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.entidades.exception.RegraDeNegocioException;
import com.talissonmelo.repositorio.UsuarioRepositorio;
import com.talissonmelo.servico.UsuarioServico;

@ActiveProfiles("test")
@SpringBootTest
public class UsuarioServiceTest {

	@Autowired
	UsuarioServico servico;
	
	@Autowired
	UsuarioRepositorio repositorio;

	@Test
	public void validarEmail() {
		// Cénario
		repositorio.deleteAll();

		// Ação ou execução
		this.servico.validarEmail("spring@gmail.com");

		// Verificação
	}
	
	@Test
	public void DeveLancarErroValidarEmail() {
		// Cénario
		Usuario usuario = this.servico.salvar(this.criarUsuario());

		// Ação ou execução
		Assertions.assertThrows(RegraDeNegocioException.class, () -> this.servico.validarEmail(usuario.getEmail()));

		// Verificação
	}

	private UsuarioDto criarUsuario() {
		UsuarioDto dto = new UsuarioDto();
		dto.setEmail("usuarioDto@gmail.com");
		dto.setNome("Usuário");
		dto.setSenha("0000000");
		return dto;
	}

}
