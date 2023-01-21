package com.talissonmelo.repositorio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.talissonmelo.entidades.Usuario;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
@DataJpaTest
public class UsuarioRepositorioTest {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void deveValidarRegistroDeEmail() {
		// Cénario
		Usuario usuario = this.criarUsuario();
		usuario.setNumero(this.usuarioRepositorio.numeroMaximo());
		usuario = this.entityManager.persist(usuario);

		// Ação ou execução
		Boolean email = this.usuarioRepositorio.existsByEmail(usuario.getEmail());

		// Verificação
		Assertions.assertTrue(email);
	}

	@Test
	public void deveRetornarFalsoQuandoUsuarioNaoCadastradoComEmail() {
		// Cénario

		// Ação ou execução
		Boolean email = this.usuarioRepositorio.existsByEmail("tay@gmail.com");

		// Verificação
		Assertions.assertFalse(email);
	}

	private Usuario criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("tay@");
		usuario.setNome("Thalis");
		usuario.setSenha("1234567");
		return usuario;
	}

}
