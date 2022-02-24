package br.com.concessionaria.controller;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.concessionaria.enums.StatusCarro;
import br.com.concessionaria.model.CarroModel;
import br.com.concessionaria.model.ClienteModel;
import br.com.concessionaria.model.VendasModel;
import br.com.concessionaria.repository.CarroRepository;
import br.com.concessionaria.repository.ClienteRepository;
import br.com.concessionaria.repository.VendasRepository;

@Controller
public class VendasController {

	@Autowired
	VendasRepository vendasRepository;

	@Autowired
	CarroRepository carroRepository;

	@Autowired
	ClienteRepository clienteRepository;

	ClienteModel clienteModel;

	@GetMapping("/vendas")
	public String vendas(Model model) {
		model.addAttribute("listaCarros", carroRepository.findAllAtivas());
		return "vendas/index";
	}

	@GetMapping("/vendas/comprar/{id}")
	public String comprar(@PathVariable Long id, Model model) {
		ClienteModel clienteOpt = clienteRepository.findByEmailAndSenha(ClienteController.getClienteStatic().getEmail(), ClienteController.getClienteStatic().getSenha());
		if (clienteOpt==null) {
			throw new IllegalArgumentException("Cliente invalído");
		}
		model.addAttribute("clienteModel", clienteOpt);
		Optional<CarroModel> carroOpt = carroRepository.findById(id);
		if (carroOpt.isEmpty()) {
			throw new IllegalArgumentException("Cliente invalído");
		}

		VendasModel venda = new VendasModel();
		venda.setCarroModel(carroOpt.get());
		venda.setClienteModel(clienteOpt);
		venda.setValorVenda(carroOpt.get().getValor());
		venda.setDataCompra(Calendar.getInstance());

		if (clienteOpt.getVendas().isEmpty()) {
			double desconto = carroOpt.get().getValor() * 0.01;
			venda.setValorVenda(carroOpt.get().getValor() - desconto);
			vendasRepository.save(venda);
			clienteOpt.getVendas().add(venda);
		} else {
			venda.setValorVenda(carroOpt.get().getValor());
			vendasRepository.save(venda);
			clienteOpt.getVendas().add(venda);
		}
		carroOpt.get().setStatusCarro(StatusCarro.VENDIDO);
		carroRepository.save(carroOpt.get());
		return "redirect:/vendas";
	}

	@GetMapping("/lista/caixa")
	public String caixa(Model model) {
		model.addAttribute("listaVendas", vendasRepository.findAll());
		model.addAttribute("caixaFinal", carroRepository.valorFinal());
		return "lista/caixa/index";
	}

	@GetMapping("/lista/caixa/excluir/{id}")
	public String excluirVenda(@PathVariable("id") Long id, Model model) {
		Optional<VendasModel> vendaOpt = vendasRepository.findById(id);
		if (vendaOpt.isEmpty()) {
			throw new IllegalArgumentException("Carro invalído");
		}

		vendasRepository.delete(vendaOpt.get());
		return "redirect:/vendas";

	}
}
