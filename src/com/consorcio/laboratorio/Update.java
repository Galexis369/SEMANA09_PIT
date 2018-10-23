package com.consorcio.laboratorio;

import com.consorcio.entidad.Laboratorio;
import com.consorcio.modelo.modeloLaboratorio;

public class Update {

	public static void main(String[] args) {
		Laboratorio lab=new Laboratorio();
		lab.setCodLaboratorio(12);
		lab.setDesLaboratorio("rrrrrr");
		new modeloLaboratorio().updateLaboratorio(lab);
	}

}
