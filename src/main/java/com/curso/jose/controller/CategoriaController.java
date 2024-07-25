package com.curso.jose.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.jose.model.Categoria;
import com.curso.jose.model.Usuario;
import com.curso.jose.service.ICategoriaService;
import com.curso.jose.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService iCategoriaService; 
	

	@Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping("/listado")
	public String listaCategoria(Model model) {
		List<Categoria> categorias =  iCategoriaService.findAll();
		model.addAttribute("categorias",categorias);
		return "categoria/listado";
	}
	
    @GetMapping("/create")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/create";
    }
	
    @PostMapping("/save")
    public String guardarCategoria(@ModelAttribute Categoria categoria, HttpSession session) {
    	Usuario usuario = iUsuarioService.finById(Long.parseLong(session.getAttribute("idusuario").toString())).get();
    	categoria.setUsuario(usuario);
    	iCategoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model modelo) {
		Categoria categoria = new Categoria();
		Optional<Categoria> optionalCategoria = iCategoriaService.get(id);
		categoria = optionalCategoria.get();
		modelo.addAttribute("categoria", categoria);
		return "categoria/editar";
	}
	
	@PostMapping("/update")
	public String update(Categoria categoria) {
		Categoria cat = new Categoria(); 
		cat=iCategoriaService.get(categoria.getId()).get();
		categoria.setUsuario(cat.getUsuario());
		iCategoriaService.update(categoria);
		return "redirect:/categoria/listado";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Categoria cat = new Categoria();
		cat = iCategoriaService.get(id).get();
		iCategoriaService.delete(id);
		return "redirect:/categoria/listado";
	}
    

}
