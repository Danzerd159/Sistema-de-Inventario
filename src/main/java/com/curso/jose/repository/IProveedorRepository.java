package com.curso.jose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.jose.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Long>{

}
