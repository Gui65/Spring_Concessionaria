package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.GerenteModel;

@Repository
public interface GerenteRepository extends JpaRepository<GerenteModel, Long>{

}
