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

import br.com.concessionaria.dto.ClienteDto;
import br.com.concessionaria.enums.Role;
import br.com.concessionaria.model.ClienteModel;
import br.com.concessionaria.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@GetMapping("/lista/clientes")
	public String clientes(Model model) {
		model.addAttribute("listaClientes", clienteRepository.findAll());
		return "lista/clientes/list";
	}

	@GetMapping("/lista/clientes/novo")
	public String novoCarro(@ModelAttribute("clienteModel") ClienteModel clienteModel) {
		return "lista/clientes/form";
	}

	@GetMapping("/lista/clientes/{id}")
	public String alterarCliente(@PathVariable("id") Long id, Model model) {
		Optional<ClienteModel> clienteOpt = clienteRepository.findById(id);
		if (clienteOpt.isEmpty()) {
			throw new IllegalArgumentException("Cliente invalído");
		}
		model.addAttribute("clienteModel", clienteOpt.get());
		return "lista/clientes/form";
	}

	@PostMapping("/lista/clientes/salvar")
	public String salvarCliente(@ModelAttribute("clienteModel") ClienteModel clienteModel) {
		clienteModel.setRole(Role.USER);
		clienteRepository.save(clienteModel);
		return "redirect:/lista/clientes";
	}

	@GetMapping("/lista/clientes/excluir/{id}")
	public String excluirCliente(@PathVariable("id") Long id, Model model) {
		Optional<ClienteModel> clienteOpt = clienteRepository.findById(id);
		if (clienteOpt.isEmpty()) {
			throw new IllegalArgumentException("Cliente invalído");
		}

		clienteRepository.delete(clienteOpt.get());
		return "redirect:/lista/clientes";
	}

	@GetMapping("/loginCliente")
	public String login(Model model) {
		ClienteDto clienteDto = new ClienteDto();
		model.addAttribute("clienteDto", clienteDto);
		return "login/loginCliente";
	}

	@PostMapping("/loginCliente")
	public String efetuarLogin(ModelMap model, ClienteDto clienteDto) {

		ClienteModel cliente = clienteRepository.findByEmailAndSenha(clienteDto.getEmail(), clienteDto.getSenha());

		if (cliente == null) {
			//session.setAttribute("clienteLogado", cliente);

			return "redirect:/loginCliente#bg";
		}
		
		return "redirect:/vendas";

	}
}
