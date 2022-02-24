package br.com.concessionaria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.concessionaria.dto.ClienteDto;
import br.com.concessionaria.dto.FuncionarioDto;
import br.com.concessionaria.enums.Role;
import br.com.concessionaria.model.ClienteModel;
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

	@GetMapping("/loginFuncionario")
	public String login(Model model) {
		FuncionarioDto funcionarioDto = new FuncionarioDto();
		model.addAttribute("funcionarioDto", funcionarioDto);
		return "login/loginFuncionario";
	}

	@PostMapping("/loginFuncionario")
	public String efetuarLogin(ModelMap model, FuncionarioDto funcionarioDto, RedirectAttributes ra) {

		FuncionarioModel funcionario = funcionarioRepository.findByEmailAndSenha(funcionarioDto.getEmail(),
				funcionarioDto.getSenha());

		if (funcionario == null) {
			// Enviar mensagem de erro
			ra.addFlashAttribute("mensagem", "Email ou Senha inválidas");
			return "redirect:/loginFuncionario";
		}

		return "redirect:/home/funcionario";

	}
	
}
