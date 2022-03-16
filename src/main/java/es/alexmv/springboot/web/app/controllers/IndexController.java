package es.alexmv.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.alexmv.springboot.web.app.model.Usuario;

@Controller
@RequestMapping(value = "/app")
public class IndexController {
	
	@Value("${index.controller.hola}")
	private String holaSpring;
	
	@GetMapping(value = {"/", "/index", "/home"})
	public String index(Model model) {
		
		model.addAttribute("titulo", holaSpring);
		
		return "index";
	}
	
	@GetMapping(value = "/perfil")
	public String perfilUsuario(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Alex");
		usuario.setApellido("Mengual");
		usuario.setEmail("alex@mail.com");
		
		model.addAttribute("titulo", "Perfil del usuario " + usuario.getNombre());
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	@GetMapping(value = "/listar")
	public String listarUsuarios(Model model) {
				
		model.addAttribute("titulo", "Listado de usuarios");
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Alex", "Mengual", "alex@mail.com"),
				new Usuario("Adrian", "Mengual", "adrian@mail.com"),
				new Usuario("Laia", "Hervella", "laia@mail.com")
				);
		
		return usuarios;
	}
	

}
