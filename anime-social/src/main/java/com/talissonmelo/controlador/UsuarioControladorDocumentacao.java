package com.talissonmelo.controlador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.entidades.dto.UsuarioResposta;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuários", description = "Gerenciamento de usuários!")
public interface UsuarioControladorDocumentacao {

	
	@Operation(summary = "Salvar usuário")
	ResponseEntity<UsuarioResposta> salvar(UsuarioDto dto);

	@Operation(summary = "listar usuário por ID")
	ResponseEntity<UsuarioResposta> listarPorId(Long id);
	
	@Operation(summary = "listar usuários")
	ResponseEntity<Page<UsuarioResposta>> listar(Pageable pageable, String nome, Integer numero, String email);
}
