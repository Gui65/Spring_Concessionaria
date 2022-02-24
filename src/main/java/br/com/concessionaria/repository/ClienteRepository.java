package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

	@Query("Select c from ClienteModel c where c.email = ?1 and c.senha = ?2")
	ClienteModel findByEmailAndSenha(@Param("email") String email, @Param("senha") String password);

}
