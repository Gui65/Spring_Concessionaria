package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
	
	@Query(value="select * from tb_cliente where ml_email =:email and pw_senha = :senha", nativeQuery = true)
	public ClienteModel loginCliente(String email, String senha);
}
