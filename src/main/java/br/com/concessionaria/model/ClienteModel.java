package br.com.concessionaria.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@PrimaryKeyJoinColumn(name = "id_cliente")
@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel extends PessoaModel{
	
	@Column(name = "dt_data_compra")
    @Temporal(TemporalType.DATE)
	private Calendar dataCompra;

    @OneToMany(mappedBy = "cliente")
    private Set<CarroModel> carroModel;
    
	public ClienteModel() {
		
	}

	public ClienteModel(String nome, String telefone, String email, String senha) {
		super(nome, telefone, email, senha);
	
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Set<CarroModel> getCarroModel() {
		return carroModel;
	}

	public void setCarroModel(Set<CarroModel> carroModel) {
		this.carroModel = carroModel;
	}

}
