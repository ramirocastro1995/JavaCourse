package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/string/{texto}")
	public String variable(@PathVariable String texto, Model model) {
	model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable");
	model.addAttribute("resultado", "el texto enviado en la ruta es : "+ texto);
	return ("variables/ver");
	}
}
