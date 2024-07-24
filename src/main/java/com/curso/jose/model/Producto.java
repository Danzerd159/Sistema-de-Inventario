package com.curso.jose.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;    
    private Integer cantidad;
    private Double precio;
    private String descripcion;
    private Date fechaCreacion;
    
    @ManyToOne
    private Proveedor proveedor;

    @ManyToOne
    private Categoria categoria;
    
    @ManyToOne
    private Usuario usuario;

	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, Integer cantidad, Double precio, String descripcion, Date fechaCreacion,
			Proveedor proveedor, Categoria categoria, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.proveedor = proveedor;
		this.categoria = categoria;
		this.usuario = usuario;
	}

	public Producto(String nombre, Integer cantidad, Double precio, String descripcion, Date fechaCreacion,
			Proveedor proveedor, Categoria categoria, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.proveedor = proveedor;
		this.categoria = categoria;
		this.usuario = usuario;
	}

	public Producto(String nombre, Integer cantidad, Double precio, String descripcion, Date fechaCreacion) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
	}

	public Producto(Long id, String nombre, Integer cantidad, Double precio, String descripcion, Date fechaCreacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + ", proveedor=" + proveedor
				+ ", categoria=" + categoria + ", usuario=" + usuario + "]";
	}
    
    
}
