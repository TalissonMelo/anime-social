package com.talissonmelo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.servico.PostagemServico;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemControlador {

	@Autowired
	private PostagemServico servico;
	
	@GetMapping
	public String listar(){
		return "OK";
		//return servico.listar();
	}
}
