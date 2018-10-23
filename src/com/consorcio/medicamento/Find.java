package com.consorcio.medicamento;
import com.consorcio.entidad.Medicamento;
import com.consorcio.modelo.modeloMedicamento;
public class Find {
	public static void main(String[] args) {
		Medicamento med=new modeloMedicamento().findMedicamento(4);
		System.out.println("ID : "+med.getCodMedicamento());
		System.out.println("DES : "+med.getNomMedicamento());
		System.out.println("LAB : "+med.getLaboratorio().
									getDesLaboratorio());
		System.out.println("PRE : "+med.getPrecioMedicamento());
		System.out.println("STOCK : "+med.getStockMedicamento());
	}

}
