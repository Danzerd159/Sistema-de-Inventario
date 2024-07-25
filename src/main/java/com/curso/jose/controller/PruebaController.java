package com.curso.jose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/prueba")
public class PruebaController {

	@GetMapping("")
	public String prueba() {
		return "/producto/listado";
	}
	
}
