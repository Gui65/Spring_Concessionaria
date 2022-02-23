package br.com.concessionaria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.concessionaria.enums.StatusCarro;
import br.com.concessionaria.model.CarroModel;
import br.com.concessionaria.repository.CarroRepository;

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

	@GetMapping("/lista/carros/{id}")
	public String alterarCarro(@PathVariable("id") Long id, Model model) {
		Optional<CarroModel> carroOpt = carroRepository.findById(id);
		if (carroOpt.isEmpty()) {
			throw new IllegalArgumentException("Carro invalído");
		}
		model.addAttribute("carroModel", carroOpt.get());
		return "lista/carros/form";
	}

	@PostMapping("/lista/carros/salvar")
	public String salvarPessoa(@ModelAttribute("carroModel") CarroModel carroModel) {
		carroModel.setStatusCarro(StatusCarro.VENDA);
		carroRepository.save(carroModel);
		return "redirect:/lista/carros";
	}
	
	@GetMapping("/lista/carros/excluir/{id}")
	public String excluirCarro(@PathVariable("id") Long id, Model model) {
		Optional<CarroModel> carroOpt = carroRepository.findById(id);
		if (carroOpt.isEmpty()) {
			throw new IllegalArgumentException("Carro invalído");
		}
		
		carroRepository.delete(carroOpt.get());
		return "redirect:/lista/carros";
	}
}
