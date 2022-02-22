package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.VendasModel;

@Repository
public interface VendasRepository extends JpaRepository<VendasModel, Long>{

}
