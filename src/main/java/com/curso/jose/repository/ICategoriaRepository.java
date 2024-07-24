package com.curso.jose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.jose.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long>{

}
