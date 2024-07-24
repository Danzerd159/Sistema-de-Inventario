package com.curso.jose.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	  	@Id
	  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nombre;
	    private String apellido;
	    private String email;
	    private String rol;
	    private String password;
	    private String conpassword;
	    
	    @OneToMany(mappedBy = "usuario")
	    private List<Categoria> categorias;

	    @OneToMany(mappedBy = "usuario")
	    private List<Proveedor> proveedores;
	    
	    @OneToMany(mappedBy = "usuario")
	    private List<Producto> productos;
	    

		public Usuario() {
			super();
		}

		public Usuario(Long id, String nombre, String apellido, String email, String rol, String password,
				String conpassword, List<Categoria> categorias, List<Proveedor> proveedores, List<Producto> productos) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.rol = rol;
			this.password = password;
			this.conpassword = conpassword;
			this.categorias = categorias;
			this.proveedores = proveedores;
			this.productos = productos;
		}

		public Usuario(String nombre, String apellido, String email, String rol, String password, String conpassword,
				List<Categoria> categorias, List<Proveedor> proveedores, List<Producto> productos) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.rol = rol;
			this.password = password;
			this.conpassword = conpassword;
			this.categorias = categorias;
			this.proveedores = proveedores;
			this.productos = productos;
		}

		public Usuario(String nombre, String apellido, String email, String rol, String password, String conpassword) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.rol = rol;
			this.password = password;
			this.conpassword = conpassword;
		}

		public Usuario(Long id, String nombre, String apellido, String email, String rol, String password,
				String conpassword) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.rol = rol;
			this.password = password;
			this.conpassword = conpassword;
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

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConpassword() {
			return conpassword;
		}

		public void setConpassword(String conpassword) {
			this.conpassword = conpassword;
		}

		public List<Categoria> getCategorias() {
			return categorias;
		}

		public void setCategorias(List<Categoria> categorias) {
			this.categorias = categorias;
		}

		public List<Proveedor> getProveedores() {
			return proveedores;
		}

		public void setProveedores(List<Proveedor> proveedores) {
			this.proveedores = proveedores;
		}

		public List<Producto> getProductos() {
			return productos;
		}

		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", rol="
					+ rol + ", password=" + password + ", conpassword=" + conpassword + ", categorias=" + categorias
					+ ", proveedores=" + proveedores + ", productos=" + productos + "]";
		}
		
		
	    
}
