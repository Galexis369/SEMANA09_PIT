package com.consorcio.entidad;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tb_marca")
public class Laboratorio implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMarca")
	private int codLaboratorio;
	@Column(name="nombre")
	private String desLaboratorio;
	//relación uno a muchos
	@OneToMany(mappedBy="laboratorio")
	private List<Medicamento> listaMedicamento;
	//relacion uno a muchos
	@OneToMany(mappedBy="laboratorio")
	private List<TipoMedicamento> listaTipoMedicamento;
	
	
	
	public int getCodLaboratorio() {
		return codLaboratorio;
	}
	public void setCodLaboratorio(int codLaboratorio) {
		this.codLaboratorio = codLaboratorio;
	}
	public String getDesLaboratorio() {
		return desLaboratorio;
	}
	public void setDesLaboratorio(String desLaboratorio) {
		this.desLaboratorio = desLaboratorio;
	}
	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	public List<TipoMedicamento> getListaTipoMedicamento() {
		return listaTipoMedicamento;
	}
	public void setListaTipoMedicamento(List<TipoMedicamento> listaTipoMedicamento) {
		this.listaTipoMedicamento = listaTipoMedicamento;
	}
	
	
}




