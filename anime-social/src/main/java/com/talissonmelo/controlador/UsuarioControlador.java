package com.talissonmelo.controlador;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.entidades.dto.UsuarioResposta;
import com.talissonmelo.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControlador {

	@Autowired
	private UsuarioServico servico;

	@PostMapping
	public ResponseEntity<UsuarioResposta> salvar(@Valid @RequestBody UsuarioDto dto) {
		Usuario usuario = servico.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioResposta(usuario));
	}
}
