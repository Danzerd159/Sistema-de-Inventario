package com.curso.jose.controller;

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

import com.curso.jose.model.Proveedor;
import com.curso.jose.model.Usuario;
import com.curso.jose.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private final  Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping("/registro")
	public String registro() {
		return "register";
	}

	@PostMapping("/save")
	public String save(Usuario usuario) {
		usuario.setRol("ADMIN");
		iUsuarioService.save(usuario);
		return "redirect:/";
	}
	
	@PostMapping("/acceder")
	public String acceder(Usuario usuario, HttpSession session) {
		Optional<Usuario> user = iUsuarioService.findByEmail(usuario.getEmail());
		if (user.isPresent()) {
			session.setAttribute("idusuario", user.get().getId());
			session.setAttribute("nombreusuario", user.get().getNombre()); 
			if (user.get().getRol().equals("ADMIN")) {
				return "index";
			}else {
				return "redirect:/";
			}
		}else {
			logger.info("Usuario no existe");
		}
		return "redirect:/";

	}
	
	@GetMapping("/cerrar")
	public String cerrarSesion(HttpSession sesion) {
		sesion.removeAttribute("idusuario");
		return "redirect:/";
	}
	
	
	@GetMapping("listado")
	public String listadoUsuarios(Model model, HttpSession sesion) {
		model.addAttribute("sesion", sesion.getAttribute("idusuario"));
		model.addAttribute("usuarios", iUsuarioService.findAll());
		return "usuario/listado";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model modelo) {
		Optional<Usuario> optionalUsuario = iUsuarioService.finById(id);
		if (optionalUsuario.isPresent()) {
			modelo.addAttribute("usuario", optionalUsuario.get());
			return "usuario/editar";
		} else {
			logger.info("Usuario no encontrado con ID: {}", id);
			return "redirect:/usuario/listado";
		}
	}
	
	@PostMapping("/update")
	public String update(Usuario usuario) {
		Optional<Usuario> userOpt = iUsuarioService.finById(usuario.getId());
		if (userOpt.isPresent()) {
			iUsuarioService.update(usuario);
		} else {
			logger.info("Usuario no encontrado con ID: {}", usuario.getId());
		}
		return "redirect:/usuario/listado";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Usuario user = new Usuario();
		user = iUsuarioService.finById(id).get();
		iUsuarioService.delete(id);
		return "redirect:/usuario/listado";
	}
}
