package br.com.projetointegracao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetointegracao.model.CarroModel;
@Repository
public interface CarroRepository extends JpaRepository<CarroModel, Long>{


}
