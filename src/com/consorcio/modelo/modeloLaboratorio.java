package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.consorcio.entidad.Laboratorio;
public class modeloLaboratorio {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	public void addLaboratorio(Laboratorio lab){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(lab);//insert into
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public void updateLaboratorio(Laboratorio lab){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(lab);//update
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public void deleteLaboratorio(int cod){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			Laboratorio lab=manager.find(Laboratorio.class, cod);
			manager.getTransaction().begin();
			manager.remove(lab);//delete 
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public Laboratorio findLaboratorio(int cod){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		Laboratorio lab=null;
		try {
			lab=manager.find(Laboratorio.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
		return lab;
	}
	
	public List<Laboratorio> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Laboratorio> data=null;
		TypedQuery<Laboratorio> resul=null;
		try {
			String hql="select la from Laboratorio la";
			resul=manager.createQuery(hql,Laboratorio.class);
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
