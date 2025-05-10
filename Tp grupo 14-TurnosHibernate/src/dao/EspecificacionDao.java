package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.EnumRubro;
import datos.Especificacion;
import datos.Servicio;

public class EspecificacionDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		session= HibernateUtil.getSessionFactory().openSession();
		tx= session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	
	public int agregar(Especificacion objeto) {
		int id=0;
		try {
			iniciaOperacion();
			id= Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch (HibernateException he) {
			manejaExcepcion(he);
		}finally {
			session.close();
		}
		return id;
	}
	
	
	
	public void actualizar(Especificacion objeto) {
		try {
			iniciaOperacion();
			session.merge(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		}finally {
			session.close();
		}
	}
	
	
	
	public void eliminar(Especificacion objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		}finally {
			session.close();
		}
	}
	
	
	
	public Especificacion traer(long idEspecificacion) {
		Especificacion objeto=null;
		try {
			iniciaOperacion();
			objeto= (Especificacion) session.get(Especificacion.class, idEspecificacion);
		} finally {
			session.close();
		} 
		return objeto;
	}
	
	
	
	public Especificacion traerEspecificacionExistente(EnumRubro rubro, String detalles, String personalInvolucrado, Servicio servicio) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Especificacion resultado = null;

	    try {
	        Query<Especificacion> query = session.createQuery(
	            "FROM Especificacion e WHERE e.rubro = :rubro AND e.detalles = :detalles AND e.personalInvolucrado = :personal AND e.servicio = :servicio", 
	            Especificacion.class
	        );
	        query.setParameter("rubro", rubro);
	        query.setParameter("detalles", detalles);
	        query.setParameter("personal", personalInvolucrado);
	        query.setParameter("servicio", servicio);

	        resultado = query.uniqueResult();
	    } finally {
	        session.close();
	    }

	    return resultado;
	}
	

	

}
