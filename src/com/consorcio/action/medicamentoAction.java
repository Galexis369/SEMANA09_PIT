package com.consorcio.action;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.api.UIData;

import com.consorcio.entidad.Laboratorio;
import com.consorcio.entidad.Medicamento;
import com.consorcio.entidad.TipoMedicamento;
import com.consorcio.modelo.modeloLaboratorio;
import com.consorcio.modelo.modeloMedicamento;
import com.consorcio.modelo.modeloTipoMedicamento;

import utils.Constantes;
@ManagedBean(name="CRUDMedicamento")
@ViewScoped
public class medicamentoAction {
	//atributo para almacenar todos los medicamentos
	private List<Medicamento> listaMedicamento;
	//Atributo para registrar
	private Medicamento medicamento;
	//Atributo para almacenar los laboratorios
	private List<Laboratorio> listaLaboratorio;
	//Atributo para referenciar la fila seleccionada del DataTable
	private UIData dtFila;
	//Atributo para lista de tipo de medicamento
	private List<TipoMedicamento> listaTipoMedicamento;
	
	
	
	//método para filtrar tipo de medicamento según el codLab
	public void cargarTipoMedicamento(){
		listaTipoMedicamento=new modeloTipoMedicamento().
				listaTipo(medicamento.getLaboratorio().getCodLaboratorio());
	}
	
	
	//Metodos para registrar medicamentos
	public void registrarMedicamento(){
		new modeloMedicamento().addMedicamento(medicamento);
		Constantes.mensaje("Sistema", "Registro grabado correc.", 
					FacesMessage.SEVERITY_INFO);	
	}

	
	
	public void nuevoMedicamento(){
		medicamento=new Medicamento();
	}
	

	public medicamentoAction(){
		medicamento = new Medicamento();
	}
	
	public List<Medicamento> getListaMedicamento() {
		listaMedicamento=new modeloMedicamento().lista();
		return listaMedicamento;
	}
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Laboratorio> getListaLaboratorio() {
		listaLaboratorio = new modeloLaboratorio().lista();
		return listaLaboratorio;
	}

	public void setListaLaboratorio(List<Laboratorio> listaLaboratorio) {
		this.listaLaboratorio = listaLaboratorio;
	}

	public UIData getDtFila() {
		return dtFila;
	}

	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}


	public List<TipoMedicamento> getListaTipoMedicamento() {
		return listaTipoMedicamento;
	}


	public void setListaTipoMedicamento(List<TipoMedicamento> listaTipoMedicamento) {
		this.listaTipoMedicamento = listaTipoMedicamento;
	}
	
	
	
	
}
