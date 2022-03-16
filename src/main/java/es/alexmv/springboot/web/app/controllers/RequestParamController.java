package es.alexmv.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/requestparam")
public class RequestParamController {
	
	@GetMapping("/index")
	public String index() {
		return "requestparam/index";
	}


	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required=false) String texto, Model model) {
		
		model.addAttribute("resultado", "El texto enviado por RequestParam es: " + texto);
		
		return "requestparam/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		
		model.addAttribute("resultado", "El saludo enviado por RequestParam es: " + saludo + " y el numero es: " + numero);
		
		return "requestparam/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		
		String saludo = request.getParameter("saludo");
		
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch (NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "El saludo enviado por RequestParam es: " + saludo + " y el numero es: " + numero);
		
		return "requestparam/ver";
	}
}
