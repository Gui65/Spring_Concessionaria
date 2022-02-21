package br.com.projetointegracao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.projetointegracao.enums.CategoriaCarro;
import br.com.projetointegracao.model.CarroModel;
import br.com.projetointegracao.repository.CarroRepository;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		CarroModel car1 = new CarroModel(CategoriaCarro.NOVO, 28900.00, 1999, "Pajero", "Mitsubishi");
		CarroModel car2 = new CarroModel(CategoriaCarro.SEMINOVO, 88900.00, 2022, "Golf", "Volksvagen");
		
		carroRepository.save(car1);
		carroRepository.save(car2);
	}
}
