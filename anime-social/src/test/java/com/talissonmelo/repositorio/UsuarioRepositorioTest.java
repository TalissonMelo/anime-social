package com.talissonmelo.repositorio;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("Validar email retornar true quando registro ja cadastrado")
	public void deveValidarRegistroDeEmail() {
		// Cénario
		Usuario usuario = this.criarUsuario();
		usuario = this.entityManager.persist(usuario);

		// Ação ou execução
		Boolean email = this.usuarioRepositorio.existsByEmail(usuario.getEmail());

		// Verificação
		Assertions.assertTrue(email);
	}

	@Test
	@DisplayName("Validar email retornar false quando email não registrado na base de dados.")
	public void deveRetornarFalsoQuandoUsuarioNaoCadastradoComEmail() {
		// Cénario

		// Ação ou execução
		Boolean email = this.usuarioRepositorio.existsByEmail("tay@gmail.com");

		// Verificação
		Assertions.assertFalse(email);
	}

	@Test
	@DisplayName("Deve salvar usuário na base de dados")
	public void salvar() {
		// Cénario
		Usuario usuario = this.criarUsuario();

		// Ação ou execução
		Usuario usuarioSalvo = this.entityManager.persist(usuario);

		// Verificação
		Assertions.assertNotNull(usuarioSalvo.getId());
	}

	@Test
	@DisplayName("Deve buscar usuário por email e retornar usuário")
	public void buscarUsuarioPorEmail() {
		// Cénario
		Usuario usuario = this.criarUsuario();
		this.usuarioRepositorio.save(usuario);

		// Ação ou execução
		Optional<Usuario> optional = this.usuarioRepositorio.listarPorEmail(usuario.getEmail());

		// Verificação
		Assertions.assertTrue(optional.isPresent());
	}

	@Test
	@DisplayName("Deve buscar usuário por email e retornar vazio")
	public void buscarPorEmail() {
		// Cénario

		// Ação ou execução
		Optional<Usuario> optional = this.usuarioRepositorio.listarPorEmail("spring@gmail.com");

		// Verificação
		Assertions.assertTrue(optional.isEmpty());
	}

	private Usuario criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("tay@");
		usuario.setNome("Thalis");
		usuario.setSenha("1234567");
		usuario.setNumero(this.usuarioRepositorio.numeroMaximo());
		return usuario;
	}

}
