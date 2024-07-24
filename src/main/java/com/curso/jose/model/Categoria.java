package com.curso.jose.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    
    @ManyToOne
    private Usuario usuario;

    
	public Categoria() {
		super();
	}


	public Categoria(Long id, String nombre, List<Producto> productos, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productos = productos;
		this.usuario = usuario;
	}


	public Categoria(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", productos=" + productos + ", usuario=" + usuario + "]";
	}

    
}
