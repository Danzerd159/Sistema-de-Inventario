package com.curso.jose.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.jose.model.Usuario;
import com.curso.jose.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return iUsuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> finById(Long id) {
		return iUsuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return iUsuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return iUsuarioRepository.findByEmail(email);
	}

	@Override
	public void update(Usuario usuario) {
		iUsuarioRepository.save(usuario);
		
	}

	@Override
	public void delete(Long id) {
		iUsuarioRepository.deleteById(id);
		
	}

}
