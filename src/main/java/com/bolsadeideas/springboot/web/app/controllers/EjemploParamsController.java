package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	/*enviar un parametro */
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required = false,defaultValue = "valor vacio" ) String texto, Model model) {
		model.addAttribute("resultado", "el texto enviado es : " + texto);
		return "params/ver";
	}
	/*enviar dos parametros */
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "el saludo enviado es : '" + saludo + "' y el numero es '" + numero + "'" );
		return "params/ver";
	}
	/*Otra forma de enviar params */
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
		numero = Integer.parseInt(request.getParameter("numero"));
		} catch(NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado", "el saludo enviado es : '" + saludo + "' y el numero es '" + numero + "'" );
		return "params/ver";
	}
}
