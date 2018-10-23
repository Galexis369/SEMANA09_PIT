package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.consorcio.entidad.Laboratorio;
import com.consorcio.entidad.TipoMedicamento;
public class modeloTipoMedicamento {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	public List<TipoMedicamento> listaTipo(int codLab){
		EntityManager manager=fabrica.createEntityManager();
		List<TipoMedicamento> data=null;
		TypedQuery<TipoMedicamento> resul=null;
		try {
			String hql="select tm from TipoMedicamento tm "+
					"where tm.laboratorio.codLaboratorio=?1";
			resul=manager.createQuery(hql,TipoMedicamento.class);
			resul.setParameter(1, codLab);
			data=resul.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();
		}
		return data;
	}
}
