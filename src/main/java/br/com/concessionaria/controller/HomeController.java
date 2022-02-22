package br.com.concessionaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home/home";
	}
	
	@GetMapping("/home/funcionario")
	public String homeFuncionario() {
		return "home/homeFuncionario";
	}
}
