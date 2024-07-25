package com.curso.jose.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.jose.model.Producto;
import com.curso.jose.model.Proveedor;
import com.curso.jose.model.Usuario;
import com.curso.jose.service.IProductoService;
import com.curso.jose.service.IProveedorService;
import com.curso.jose.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	private final  Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IProveedorService iProveedorService;
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	
	@GetMapping("/create")
	public String create(Model modelo) {
        List<Proveedor> listaProveedor = iProveedorService.findAll();
        modelo.addAttribute("listaProveedor", listaProveedor);
        modelo.addAttribute("producto", new Producto()); 
		return "producto/create";
	}
	
	@GetMapping("/listado")
	public String listado(Model model, HttpSession sesion) {
	    model.addAttribute("sesion", sesion.getAttribute("idusuario"));

	    List<Producto> productos = iProductoService.findAll();
	    model.addAttribute("productos", productos);
	    
	    // Log de información
	    logger.info("Productos recuperados: {}", productos);

	    // Verificar si hay proveedores asociados
	    for (Producto producto : productos) {
	        if (producto.getProveedor() != null) {
	            logger.info("Producto ID {}: Proveedor - {}", producto.getId(), producto.getProveedor().getNombre());
	        } else {
	            logger.warn("Producto ID {}: Sin proveedor asociado", producto.getId());
	        }
	    }

	    return "producto/listado";
	}

	
	@PostMapping("/save")
	public String save(Model modelo, @RequestParam("proveedorId") Long proveedorId, Producto producto, HttpSession session) {
	    Date fechaCreacion = new Date();
	    producto.setFechaCreacion(fechaCreacion);
	    
	    // Asignar usuario al producto
	    Usuario usuario = iUsuarioService.finById(Long.parseLong(session.getAttribute("idusuario").toString())).get();
	    producto.setUsuario(usuario);

	    // Buscar el proveedor y asignarlo al producto
	    Proveedor proveedor = iProveedorService.get(proveedorId).orElse(null);
	    if (proveedor != null) {
	        producto.setProveedor(proveedor);
	    }
	    
	    // Guardar el producto
	    iProductoService.save(producto);
	    
	    return "redirect:/producto/listado";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model modelo) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = iProductoService.get(id);
        producto = optionalProducto.get();
        List<Proveedor> listaProveedor = iProveedorService.findAll();
        modelo.addAttribute("listaProveedor", listaProveedor);
        modelo.addAttribute("producto", producto);
        return "producto/editar";
	}
	
	@PostMapping("/update")
	public String update(Producto producto) throws IOException {
        Date fechaCreacion = new Date();
        producto.setFechaCreacion(fechaCreacion);
        Producto p = new Producto();
        p = iProductoService.get(producto.getId()).get();
        producto.setUsuario(p.getUsuario());
        iProductoService.update(producto);
        return "redirect:/producto/listado";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Producto p = new Producto();
		p = iProductoService.get(id).get();
		iProductoService.delete(id);
		return "redirect:/producto/listado";
	}
	
}
