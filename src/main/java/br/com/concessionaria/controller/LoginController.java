package br.com.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.concessionaria.model.ClienteModel;
import br.com.concessionaria.repository.ClienteRepository;

@Controller
public class LoginController {
	
	@Autowired
	private ClienteRepository clienteRepository;
			
	@GetMapping("/login")
	public String home() {
		return "login/index";
	}
	
	@PostMapping("/logarCliente")
	public String logarCliente(Model model, ClienteModel clienteModel) {
		ClienteModel cliente = this.clienteRepository.loginCliente(clienteModel.getEmail(), clienteModel.getSenha());
		if(cliente != null) {
			return "redirect:/";
		}
		model.addAttribute("erro", "Usuário ou senha invalídos");
		return "login/index";
	}
}
