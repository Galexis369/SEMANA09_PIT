package com.consorcio.laboratorio;

import com.consorcio.entidad.Laboratorio;
import com.consorcio.modelo.modeloLaboratorio;

public class Find {
	public static void main(String[] args) {
		Laboratorio lab=new modeloLaboratorio().findLaboratorio(7);
		System.out.println("C�digo : "+lab.getCodLaboratorio());
		System.out.println("Descripci�n : "+lab.getDesLaboratorio());
		
	}
}
