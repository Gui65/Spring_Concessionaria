package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.concessionaria.model.FuncionarioModel;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

	@Query("Select c from FuncionarioModel c where c.email = ?1 and c.senha = ?2")
	FuncionarioModel findByEmailAndSenha(@Param("email") String email, @Param("senha") String password);

}
