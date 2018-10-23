package com.consorcio.medicamento;
import java.text.SimpleDateFormat;
import java.util.List;

import com.consorcio.entidad.Laboratorio;
import com.consorcio.entidad.Medicamento;
import com.consorcio.modelo.modeloMedicamento;
public class Add {
	public static void main(String[] args) {
		try {
			Laboratorio lab=new Laboratorio();
			lab.setCodLaboratorio(2);
			
			Medicamento med=new Medicamento();
			med.setNomMedicamento("Paracetamol 500 mg");
			med.setPrecioMedicamento(15.60);
			med.setStockMedicamento(25);
			//llave fk
			med.setLaboratorio(lab);
			new modeloMedicamento().addMedicamento(med);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
