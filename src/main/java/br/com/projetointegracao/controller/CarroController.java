package br.com.projetointegracao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projetointegracao.model.CarroModel;
import br.com.projetointegracao.repository.CarroRepository;

@Controller
public class CarroController {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public CarroController(CarroRepository carroRepository) {
		this.carroRepository = carroRepository;
	}
	
	@GetMapping("/lista/carros")
	public String carros(Model model) {
		model.addAttribute("listaCarros", carroRepository.findAll());
		return "lista/carros/index";
	}
	
	@GetMapping("/lista/carros/novo")
	public String novoCarro(@ModelAttribute("carroModel") CarroModel carroModel) {
		return "lista/carros/form";
	}
	
	@PostMapping("/lista/carros/salvar")
	public String salvarPessoa(@ModelAttribute("carroModel") CarroModel carroModel) {
		carroRepository.save(carroModel);
		return "redirect:/lista/carros";
	}
}
