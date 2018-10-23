package com.consorcio.modelo;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Medicamento;
public class modeloMedicamento {
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	public void addMedicamento(Medicamento med){
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(med);
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
	

	public Medicamento findMedicamento(int cod){
		EntityManager manager=fabrica.createEntityManager();
		Medicamento med=null;
		try {
			med=manager.find(Medicamento.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
		return med;
	}
	//listar todos los medicamentos "hql"
	public List<Medicamento> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Medicamento> data=null;
		TypedQuery<Medicamento> resul=null;
		try {
			String hql="select m from Medicamento m";
			resul=manager.createQuery(hql,Medicamento.class);
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
	//listar todos los medicamentos que inicien con la letra a
	public List<Medicamento> listaXnombre(String nom){
		EntityManager manager=fabrica.createEntityManager();
		List<Medicamento> data=null;
		TypedQuery<Medicamento> resul=null;
		try {
			String hql="select m from Medicamento m where "+
						"m.nomMedicamento like concat(:param,'%')";
			resul=manager.createQuery(hql,Medicamento.class);
			resul.setParameter("param", nom);
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
	//listar todos los medicamentos según código de laboratorio
		public List<Medicamento> listaXLaboratorio(int cod){
			EntityManager manager=fabrica.createEntityManager();
			List<Medicamento> data=null;
			TypedQuery<Medicamento> resul=null;
			try {
				String hql="select m from Medicamento m where "+
							"m.laboratorio.codLaboratorio=?1";
				resul=manager.createQuery(hql,Medicamento.class);
				resul.setParameter(1, cod);
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
		//listar el medicamento más caro
				public Medicamento medicamentoCaro(){
					EntityManager manager=fabrica.createEntityManager();
					Medicamento med=null;
					TypedQuery<Medicamento> resul=null;
					try {
						String hql="select m from Medicamento m where "+
									"m.precioMedicamento="+
									"(select max(x.precioMedicamento) from "+
									"Medicamento x)";
						resul=manager.createQuery(hql,Medicamento.class);
						med=resul.getResultList().get(0);
					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						manager.close();
						fabrica.close();
					}
					return med;
				}		
		
		//actualizar precio de todos los medicamentos
		public int updatePrecio(double porcentaje){
			EntityManager manager=fabrica.createEntityManager();
			int resu=-1;
			Query q=null;
			try {
				String hql="update Medicamento m set m.precioMedicamento="+
							"precioMedicamento+precioMedicamento*?1";
				manager.getTransaction().begin();
				q=manager.createQuery(hql);
				q.setParameter(1, porcentaje);
				resu=q.executeUpdate();
				manager.getTransaction().commit();
			} catch (Exception e) {
				manager.getTransaction().rollback();
				e.printStackTrace();
			}
			finally {
				manager.close();
				fabrica.close();
			}
			return resu;
		}
				
				
				
				
				
				
}

