package com.talissonmelo.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.talissonmelo.entidade.Postagem;
import com.talissonmelo.entidade.Usuario;
import com.talissonmelo.repositorio.PostagemRepositorio;

@Configuration
public class Teste implements CommandLineRunner {
	
	@Autowired
	private PostagemRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Usuario usuario = new Usuario((long) 1, "deku@gmail.com");
		Postagem p1 = new Postagem(null, sdf.parse("21/02/2023"), "Partiu Viagem", "Vou viajar para São paulo. Bjs", usuario);
		Postagem p2 = new Postagem(null, sdf.parse("21/12/2023"), "Dia especial", "Parabéns pelo dia!.", usuario);
		
		repositorio.saveAll(Arrays.asList(p1, p2));
	}
}
