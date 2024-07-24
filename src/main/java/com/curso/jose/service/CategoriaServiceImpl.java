package com.curso.jose.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.jose.model.Categoria;
import com.curso.jose.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepository iCategoriaRepository;

	@Override
	public Categoria save(Categoria categoria) {
		return iCategoriaRepository.save(categoria);
	}

	@Override
	public Optional<Categoria> get(Long id) {
		return iCategoriaRepository.findById(id);
	}

	@Override
	public void update(Categoria categoria) {
		iCategoriaRepository.save(categoria);
		
	}

	@Override
	public void delete(Long id) {
		iCategoriaRepository.deleteById(id);;
		
	}

	@Override
	public List<Categoria> findAll() {
		return iCategoriaRepository.findAll();
	}

}
