package com.consorcio.entidad;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="tb_modelo")
public class TipoMedicamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idModelo")
	private int codTipoMedicamento;
	@Column(name="nombre")
	private String nomTipoMedicamento;
	//relacion uno a muchos con medicamento
	@OneToMany(mappedBy="tipoMedicamento")
	private List<Medicamento> listaMedicamento;
	//relacion muchos a uno con Laboratorio
	@ManyToOne
	@JoinColumn(name="idMarca")
	private Laboratorio laboratorio;
	
	
	public int getCodTipoMedicamento() {
		return codTipoMedicamento;
	}
	public void setCodTipoMedicamento(int codTipoMedicamento) {
		this.codTipoMedicamento = codTipoMedicamento;
	}
	public String getNomTipoMedicamento() {
		return nomTipoMedicamento;
	}
	public void setNomTipoMedicamento(String nomTipoMedicamento) {
		this.nomTipoMedicamento = nomTipoMedicamento;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	
}
