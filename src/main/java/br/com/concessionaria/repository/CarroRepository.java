package br.com.concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.CarroModel;
@Repository
public interface CarroRepository extends CrudRepository<CarroModel, Long>{
	
	@Query(value = "select * from tb_carro where st_status = 1", nativeQuery = true)
	List<CarroModel> findAllAtivas();
	
	@Query(value = "select * from tb_carro where st_status = 0", nativeQuery = true)
	List<CarroModel> findAllInativos();
	
	@Query(value = "select sum (vl_valor_venda) from tb_vendas", nativeQuery= true)
	Double valorFinal();
}
