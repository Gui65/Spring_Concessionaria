//package br.com.concessionaria;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import br.com.concessionaria.enums.CategoriaCarro;
//import br.com.concessionaria.model.CarroModel;
//import br.com.concessionaria.model.ClienteModel;
//import br.com.concessionaria.model.FuncionarioModel;
//import br.com.concessionaria.repository.CarroRepository;
//import br.com.concessionaria.repository.ClienteRepository;
//import br.com.concessionaria.repository.FuncionarioRepository;
//
//@Component
//@Transactional
//public class PopulacaoInicialBanco implements CommandLineRunner {
//	
//	@Autowired
//	private CarroRepository carroRepository;
//	
//	@Autowired
//	private ClienteRepository clienteRepository;
//	
//	@Autowired
//	private FuncionarioRepository funcionarioRepository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		CarroModel car1 = new CarroModel(CategoriaCarro.NOVO, 28900.00, 1999, "Pajero", "Mitsubishi");
//		CarroModel car2 = new CarroModel(CategoriaCarro.SEMINOVO, 88900.00, 2022, "Golf", "Volksvagen");
//		
//		carroRepository.save(car1);
//		carroRepository.save(car2);
//		
//		ClienteModel cliente1 = new ClienteModel("Guilherme", "999999999", "guimatos@hotmail.com", "Gui");
//		ClienteModel cliente2 = new ClienteModel("Anni", "8888888", "anicarol@hotmail.com", "Anni");
//		
//		clienteRepository.save(cliente1);
//		clienteRepository.save(cliente2);
//		
//		FuncionarioModel gerente1 = new FuncionarioModel("Joao", "77777777", "joao@hotmail.com", "Joao");
//		FuncionarioModel gerente2 = new FuncionarioModel("Roberta", "6666666", "roberta@hotmail.com", "Roberta");
//		
//		funcionarioRepository.save(gerente1);
//		funcionarioRepository.save(gerente2);
//		
//	}
//}
