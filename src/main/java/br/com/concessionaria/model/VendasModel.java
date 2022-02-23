package br.com.concessionaria.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_VENDAS")
@SequenceGenerator(allocationSize = 1, name = "vendas", sequenceName = "sq_vendas")
public class VendasModel {
	
	@Id
	@GeneratedValue(generator = "vendas", strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_data_compra")
	private Calendar dataCompra;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clienteModel_id")
	private ClienteModel clienteModel;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carroModel_id")
	private CarroModel carroModel;
	
	@Column(name = "vl_valor_venda")
	private Double valorVenda;

	public VendasModel(){
		
	}
	
	public VendasModel(Calendar dataCompra, ClienteModel clienteModel, CarroModel carroModel,
			Double valorVenda) {
		super();
		this.dataCompra = dataCompra;
		this.clienteModel = clienteModel;
		this.carroModel = carroModel;
		this.valorVenda = valorVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public CarroModel getCarroModel() {
		return carroModel;
	}

	public void setCarroModel(CarroModel carroModel) {
		this.carroModel = carroModel;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
}
