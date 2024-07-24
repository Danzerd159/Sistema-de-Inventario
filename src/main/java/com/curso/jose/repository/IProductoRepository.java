package com.curso.jose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.jose.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{

}
