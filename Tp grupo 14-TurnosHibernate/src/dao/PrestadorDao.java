package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Prestador;
import datos.Servicio;

public class PrestadorDao {
	
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
	
	
	
	public int agregar(Prestador objeto) {
	    int id = 0;
	    try {
	        iniciaOperacion();
	        id = Integer.parseInt(session.save(objeto).toString()); 
	        tx.commit();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	    } finally {
	    	session.close();
	    }
	    return id;
	}
	
	
	
	public void actualizar(Prestador objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		}finally {
			session.close();
		}
	}
	
	
	
	public void eliminar(Prestador objeto) {
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
	
	
	
	public Prestador traer(int idPrestador) {
		Prestador objeto=null;
		try {
			iniciaOperacion();
			objeto= (Prestador) session.get(Prestador.class, idPrestador);
		} finally {
			session.close();
		} 
		return objeto;
	}
	
	
	
	public List<Prestador> traerTodos() {
	    List<Prestador> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        String hql = "FROM Prestador";
	        Query<Prestador> query = session.createQuery(hql, Prestador.class);
	        lista = query.list();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	
	
	public Prestador traer(String razonSocial) {
	    Prestador prestador = null;
	    try {
	        iniciaOperacion();
	        String hql = "FROM Prestador s WHERE s.razonSocial = :razonSocial";
	        Query<Prestador> query = session.createQuery(hql, Prestador.class);
	        query.setParameter("razonSocial", razonSocial);
	        prestador = query.uniqueResult();
	    } finally {
	        session.close();
	    }
	    return prestador;
	}

}
