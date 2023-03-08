package com.talissonmelo.controlador;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.talissonmelo.entidades.Usuario;
import com.talissonmelo.entidades.conversao.UsuarioRespostaModel;
import com.talissonmelo.entidades.dto.UsuarioDto;
import com.talissonmelo.entidades.dto.UsuarioResposta;
import com.talissonmelo.servico.UsuarioServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControlador implements UsuarioControladorDocumentacao {

	private static final Logger log = LoggerFactory.getLogger(UsuarioControlador.class);

	@Autowired
	private UsuarioServico servico;

	@Autowired
	private UsuarioRespostaModel model;

	@PostMapping
	public ResponseEntity<UsuarioResposta> salvar(@Valid @RequestBody UsuarioDto dto) {
		log.info("Salvando usuários" + dto.toString());
		Usuario usuario = servico.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(this.model.paraUsuarioResposta(usuario));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioResposta> listarPorId(@PathVariable Long id) {
		log.info("Listando usuário de ID: " + id);
		UsuarioResposta usuarioResposta = this.model.paraUsuarioResposta(servico.listarPorId(id));
		return ResponseEntity.ok().body(usuarioResposta);
	}

	@GetMapping
	public ResponseEntity<Page<UsuarioResposta>> listar(@PageableDefault(size = 10) Pageable pageable,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "numero", required = false) Integer numero,
			@RequestParam(value = "email", required = false) String email) {
		log.info("Listando usuários");
		Page<Usuario> usuarios = this.servico.listar(pageable, nome, numero, email);
		List<UsuarioResposta> usuarioRespostas =  this.model.paraUsuarioRespostas(usuarios.getContent());
		Page<UsuarioResposta> paginacao = new PageImpl<>(usuarioRespostas, pageable, usuarios.getTotalElements());		
		return ResponseEntity.ok().body(paginacao);
	}
}
