package com.talissonmelo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.talissonmelo.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	@Query(nativeQuery = true, value = "select usu.* from usuario usu where usu.email = ':email'")
	Optional<Usuario> listarPorEmail(String email);

	boolean existsByEmail(String email);
}
