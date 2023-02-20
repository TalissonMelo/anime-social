package com.talissonmelo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.talissonmelo.entidade.Postagem;

public interface PostagemRepositorio  extends MongoRepository<Postagem, String> { 

}
