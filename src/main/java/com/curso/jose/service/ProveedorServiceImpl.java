package com.curso.jose.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.jose.model.Proveedor;
import com.curso.jose.repository.IProveedorRepository;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	private IProveedorRepository iProveedorRepository;
	
	@Override
	public Proveedor save(Proveedor proveedor) {
		return iProveedorRepository.save(proveedor);
	}

	@Override
	public Optional<Proveedor> get(Long id) {
		return iProveedorRepository.findById(id);
	}

	@Override
	public void update(Proveedor proveedor) {
		iProveedorRepository.save(proveedor);
		
	}

	@Override
	public void delete(Long id) {
		iProveedorRepository.deleteById(id);
		
	}

	@Override
	public List<Proveedor> findAll() {
		return iProveedorRepository.findAll();
	}

}
