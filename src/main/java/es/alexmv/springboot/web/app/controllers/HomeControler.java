package es.alexmv.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {
	
	@GetMapping
	public String home() {
		return "redirect:/app/index";
	}

}
