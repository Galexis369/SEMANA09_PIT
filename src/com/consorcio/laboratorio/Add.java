package com.consorcio.laboratorio;
import com.consorcio.entidad.Laboratorio;
import com.consorcio.modelo.modeloLaboratorio;
public class Add {
	public static void main(String[] args) {
		Laboratorio lab=new Laboratorio();
		lab.setDesLaboratorio("laaaaaaa");
		new modeloLaboratorio().addLaboratorio(lab);
	}
}
