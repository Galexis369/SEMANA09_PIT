package com.consorcio.entidad;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table(name="tb_herramienta")
public class Medicamento implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idHerramienta")
	private int codMedicamento;
	@Column(name="nombre")
	private String nomMedicamento;
	@Column(name="stock")
	private int stockMedicamento;
	@Column(name="precio")
	private double precioMedicamento;

	
	//relación muchos a uno
	@ManyToOne
	@JoinColumn(name="idMarca")//nombre de la columna "llave fk"
	private Laboratorio laboratorio;
	//relación uno a muchos 

	
	//relación muchos a uno con TipoMedicamento
	@ManyToOne
	@JoinColumn(name="idModelo")
	private TipoMedicamento tipoMedicamento;
	
	
	//Constructor
		public Medicamento(){
			laboratorio = new Laboratorio();
			tipoMedicamento=new TipoMedicamento();
		}
	
	public int getCodMedicamento() {
		return codMedicamento;
	}
	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	public String getNomMedicamento() {
		return nomMedicamento;
	}
	public void setNomMedicamento(String nomMedicamento) {
		this.nomMedicamento = nomMedicamento;
	}
	public int getStockMedicamento() {
		return stockMedicamento;
	}
	public void setStockMedicamento(int stockMedicamento) {
		this.stockMedicamento = stockMedicamento;
	}
	public double getPrecioMedicamento() {
		return precioMedicamento;
	}
	public void setPrecioMedicamento(double precioMedicamento) {
		this.precioMedicamento = precioMedicamento;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}



	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
	
}






