package es.alexmv.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pathvariable")
public class PathVariableController {
	
	@GetMapping("/index")
	public String index() {
		return "pathvariable/index";
	}

	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		
		model.addAttribute("resultado", texto);
		
		return "pathvariable/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		
		model.addAttribute("resultado", "Texto: " + texto + ", numero: " + numero);
		
		return "pathvariable/ver";
	}	
}
