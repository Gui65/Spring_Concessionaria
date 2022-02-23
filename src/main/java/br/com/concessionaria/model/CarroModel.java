package br.com.concessionaria.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.concessionaria.enums.CategoriaCarro;
import br.com.concessionaria.enums.StatusCarro;

@Entity
@Table(name = "TB_CARRO")
@SequenceGenerator(allocationSize = 1, name = "carro", sequenceName = "sq_carro")
public class CarroModel {

	@Id
	@GeneratedValue(generator = "carro", strategy = GenerationType.IDENTITY)
	@Column(name = "id_carro")
	private Long id;

	@Column(name = "ct_categoria")
	private CategoriaCarro categoria;

	@Column(name = "vl_valor")
	private Double valor;

	@Column(name = "dt_ano")
	private Integer ano;

	@Column(name = "md_modelo")
	private String modelo;
	
	@Column(name = "mc_marca")
	private String marca;
	
	@Column(name = "st_status")
	private StatusCarro status;
	
	@OneToOne(mappedBy = "carroModel")
	private VendasModel venda;
	
	public CarroModel() {

	}

	public CarroModel(CategoriaCarro categoria, Double valor, Integer ano, String modelo, String marca) {
		this.categoria = categoria;
		this.valor = valor;
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
		this.status = StatusCarro.VENDA;
	}
	
	
	public StatusCarro getStatus() {
		return status;
	}

	public void setStatusCarro(StatusCarro status) {
		this.status = status;
	}

	public CategoriaCarro getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaCarro categoria) {
		this.categoria = categoria;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public VendasModel getVenda() {
		return venda;
	}

	public void setVenda(VendasModel venda) {
		this.venda = venda;
	}
	
	

}
