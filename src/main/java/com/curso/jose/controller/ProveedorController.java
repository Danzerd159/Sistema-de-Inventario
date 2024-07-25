package com.curso.jose.controller;



import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.jose.model.Producto;
import com.curso.jose.model.Proveedor;
import com.curso.jose.model.Usuario;
import com.curso.jose.service.IProveedorService;
import com.curso.jose.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService iProveedorService;
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping("/create")
	public String create() {
		return "proveedor/create";
	}
	
	@GetMapping("/listado")
	public String listado(Model model, HttpSession sesion) {
		model.addAttribute("sesion", sesion.getAttribute("idusuario"));
		model.addAttribute("proveedors", iProveedorService.findAll());
		return "proveedor/listado";
	}
	@PostMapping("/save")
	public String save(Proveedor proveedor, HttpSession session){
		Usuario usuario = iUsuarioService.finById(Long.parseLong(session.getAttribute("idusuario").toString())).get();
		proveedor.setUsuario(usuario);
		iProveedorService.save(proveedor);
		return "redirect:/proveedor/listado";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model modelo) {
		Proveedor proveedor = new Proveedor();
		Optional<Proveedor> optionalProveedor = iProveedorService.get(id);
		proveedor = optionalProveedor.get();
		modelo.addAttribute("proveedor", proveedor);
		return "proveedor/editar";
	}
	
	@PostMapping("/update")
	public String update(Proveedor proveedor) {
		Proveedor pr = new Proveedor(); 
		pr=iProveedorService.get(proveedor.getId()).get();
		proveedor.setUsuario(pr.getUsuario());
		iProveedorService.update(proveedor);
		return "redirect:/proveedor/listado";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Proveedor pr = new Proveedor();
		pr = iProveedorService.get(id).get();
		iProveedorService.delete(id);
		return "redirect:/proveedor/listado";
	}
	
}
