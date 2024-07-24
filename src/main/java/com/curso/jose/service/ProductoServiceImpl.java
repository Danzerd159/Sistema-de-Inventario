package com.curso.jose.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.jose.model.Producto;
import com.curso.jose.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	public Producto save(Producto producto) {
		return iProductoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Long id) {
		return iProductoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		iProductoRepository.save(producto);
		
	}

	@Override
	public void delete(Long id) {
		iProductoRepository.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		return iProductoRepository.findAll();
	}

}
