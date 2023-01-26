package com.talissonmelo.controlador;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.conversao.UsuarioRespostaModel;
import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.entidades.dto.UsuarioResposta;
import com.talissonmelo.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControlador {

	@Autowired
	private UsuarioServico servico;
	
	@Autowired
	private UsuarioRespostaModel model;

	@PostMapping
	public ResponseEntity<UsuarioResposta> salvar(@Valid @RequestBody UsuarioDto dto) {
		Usuario usuario = servico.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(this.model.paraUsuarioResposta(usuario));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioResposta> listarPorId(@PathVariable Long id) {
		UsuarioResposta usuarioResposta = this.model.paraUsuarioResposta(servico.listarPorId(id));
		return ResponseEntity.ok().body(usuarioResposta);
	}
	
	public ResponseEntity<List<UsuarioResposta>> listar() {
		List<UsuarioResposta> usuarioRespostas = this.model.paraUsuarioRespostas(this.servico.listar());
		return ResponseEntity.ok().body(usuarioRespostas);
	}
}
