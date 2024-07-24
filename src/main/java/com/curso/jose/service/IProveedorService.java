package com.curso.jose.service;

import java.util.List;
import java.util.Optional;

import com.curso.jose.model.Proveedor;

public interface IProveedorService {
	
	Proveedor save(Proveedor proveedor);
	Optional<Proveedor> get(Long id);
	void update(Proveedor proveedor);
	void delete(Long id);
	List<Proveedor> findAll();
}
