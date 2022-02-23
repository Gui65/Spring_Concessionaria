package br.com.concessionaria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.concessionaria.enums.Role;
import br.com.concessionaria.model.FuncionarioModel;
import br.com.concessionaria.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public FuncionarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	@GetMapping("/lista/funcionarios")
	public String funcionarios(Model model) {
		model.addAttribute("listaFuncionarios", funcionarioRepository.findAll());
		return "lista/funcionarios/list";
	}
	
	@GetMapping("/lista/funcionarios/novo")
	public String novoFuncionario(@ModelAttribute("funcionarioModel") FuncionarioModel funcionarioModel) {
		return "lista/funcionarios/form";
	}

	@GetMapping("/lista/funcionarios/{id}")
	public String alterarFuncionario(@PathVariable("id") Long id, Model model) {
		Optional<FuncionarioModel> funcionarioOpt = funcionarioRepository.findById(id);
		if (funcionarioOpt.isEmpty()) {
			throw new IllegalArgumentException("Funcionario invalído");
		}
		model.addAttribute("funcionarioModel", funcionarioOpt.get());
		return "lista/funcionarios/form";
	}

	@PostMapping("/lista/funcionarios/salvar")
	public String salvarFuncionario(@ModelAttribute("funcionarioModel") FuncionarioModel funcionarioModel) {
		funcionarioModel.setRole(Role.ADMIN);
		funcionarioRepository.save(funcionarioModel);
		return "redirect:/lista/funcionarios";
	}
	
	@GetMapping("/lista/funcionarios/excluir/{id}")
	public String excluirFuncionario(@PathVariable("id") Long id, Model model) {
		Optional<FuncionarioModel> funcionarioOpt = funcionarioRepository.findById(id);
		if (funcionarioOpt.isEmpty()) {
			throw new IllegalArgumentException("Funcionario invalído");
		}
		
		funcionarioRepository.delete(funcionarioOpt.get());
		return "redirect:/lista/funcionarios";
	}
}
