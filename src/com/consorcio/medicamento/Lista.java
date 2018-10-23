package com.consorcio.medicamento;

import java.util.List;

import com.consorcio.entidad.Medicamento;
import com.consorcio.modelo.modeloMedicamento;

public class Lista {
	public static void main(String[] args) {
		List<Medicamento> data=new modeloMedicamento().lista(); 
		for(Medicamento m: data)
			System.out.println(m.getCodMedicamento()+"\t"+
							   m.getNomMedicamento());
	
	}
	
	
	
}
