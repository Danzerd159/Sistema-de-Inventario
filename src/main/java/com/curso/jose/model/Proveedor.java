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
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ruc;
    private String correo;
    private String telefono;
    
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
    
    @ManyToOne
    private Usuario usuario;

	public Proveedor() {
		super();
	}

	public Proveedor(String nombre, String ruc, String correo, String telefono, List<Producto> productos,
			Usuario usuario) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
		this.correo = correo;
		this.telefono = telefono;
		this.productos = productos;
		this.usuario = usuario;
	}

	public Proveedor(String nombre, String ruc, String correo, String telefono) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
		this.correo = correo;
		this.telefono = telefono;
	}

	public Proveedor(Long id, String nombre, String ruc, String correo, String telefono, List<Producto> productos,
			Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ruc = ruc;
		this.correo = correo;
		this.telefono = telefono;
		this.productos = productos;
		this.usuario = usuario;
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

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", ruc=" + ruc + ", correo=" + correo + ", telefono="
				+ telefono + ", productos=" + productos + ", usuario=" + usuario + "]";
	}
    
    
}
