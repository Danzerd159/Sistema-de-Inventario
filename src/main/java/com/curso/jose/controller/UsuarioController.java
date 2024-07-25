package com.curso.jose.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
