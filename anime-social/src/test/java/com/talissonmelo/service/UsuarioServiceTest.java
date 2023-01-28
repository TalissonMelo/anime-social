package com.talissonmelo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.talissonmelo.entidades.exception.RegraDeNegocioException;
import com.talissonmelo.repositorio.UsuarioRepositorio;
import com.talissonmelo.servico.UsuarioServico;

@ActiveProfiles("test")
@SpringBootTest
public class UsuarioServiceTest {

	@MockBean
	UsuarioRepositorio repositorio;

	@MockBean
	UsuarioServico servico;

	@Test
	public void validarEmail() {
		// Cénario
		Mockito.when(repositorio.existsByEmail(Mockito.anyString())).thenReturn(false);

		// Ação ou execução
		this.servico.validarEmail("spring@gmail.com");

		// Verificação
	}

	@Test
	public void DeveLancarErroValidarEmail() {
		// Cénario
		Mockito.when(repositorio.existsByEmail(Mockito.anyString())).thenReturn(true);

		// Ação ou execução
		Assertions.assertThrows(RegraDeNegocioException.class, () -> this.servico.validarEmail("usuarioDto@gmail.com"));

		// Verificação
	}
}
