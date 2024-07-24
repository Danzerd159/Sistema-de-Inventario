package com.curso.jose.service;

import java.util.List;
import java.util.Optional;

import com.curso.jose.model.Usuario;

public interface IUsuarioService {
	List<Usuario> findAll();
	Optional<Usuario> finById(Long id);
	Usuario save(Usuario usuario);
	Optional<Usuario> findByEmail(String email);
	void update (Usuario usuario);
	void delete (Long id);
}
