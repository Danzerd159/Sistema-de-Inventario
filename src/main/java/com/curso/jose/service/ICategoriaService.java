package com.curso.jose.service;

import java.util.List;
import java.util.Optional;

import com.curso.jose.model.Categoria;

public interface ICategoriaService {
	
	Categoria save(Categoria categoria);
	Optional<Categoria> get(Long id);
	void update(Categoria categoria);
	void delete(Long id);
	List<Categoria> findAll();
}
