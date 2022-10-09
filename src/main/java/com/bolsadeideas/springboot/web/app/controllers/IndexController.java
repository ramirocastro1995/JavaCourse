package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	@GetMapping({"/index","/","", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework!");
		return "index";
	}
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Ramiro");
		usuario.setApellido("Castro");
		usuario.setEmail("ramiro@castro.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();/*se puede usar Arrays.asList()*/
			usuarios.add(new Usuario("Ramiro", "castro","b@.com"));
			usuarios.add(new Usuario("Ramiro", "castro","b@.com"));
			usuarios.add(new Usuario("Ramiro", "castro","b@.com"));
		return usuarios;
		
	}

}
