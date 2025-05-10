package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Disponibilidad;
import datos.Servicio;

public class ServicioDao {
	
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
	
	
	
	
	public int agregar(Servicio objeto) {
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
	
	
	
	public void actualizar(Servicio objeto) {
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
	
	
	
	public void eliminar(Servicio objeto) {
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
	
	
	
	public Servicio traer(long idServicio) {
		Servicio objeto=null;
		try {
			iniciaOperacion();
			objeto= (Servicio) session.get(Servicio.class, idServicio);
		} finally {
			session.close();
		} 
		return objeto;
	}
	
	
	
	public Servicio traerServicio(String nombre) {
	    Servicio servicio = null;
	    try {
	        iniciaOperacion();
	        String hql = "FROM Servicio s WHERE s.nombre = :nombre";
	        Query<Servicio> query = session.createQuery(hql, Servicio.class);
	        query.setParameter("nombre", nombre);
	        servicio = query.uniqueResult();
	    } finally {
	        session.close();
	    }
	    return servicio;
	}
	
	
	
	public List<Servicio> traerServiciosPorPrestador(int idPrestador) {
	    List<Servicio> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        String hql = "FROM Servicio s WHERE s.prestador.id = :idPrestador";
	        Query<Servicio> query = session.createQuery(hql, Servicio.class);
	        query.setParameter("idPrestador", idPrestador);
	        lista = query.list();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	
	
	public List<Servicio> traerTodos() {
	    List<Servicio> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        String hql = "FROM Servicio";
	        Query<Servicio> query = session.createQuery(hql, Servicio.class);
	        lista = query.list();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	
	
	public Servicio traerPorNombreConDisponibilidadesYTurnos(String nombreServicio) {
	    Servicio servicio = null;
	    try {
	        iniciaOperacion();
	        String hql = "SELECT DISTINCT s FROM Servicio s "
	                   + "JOIN FETCH s.lstDisponibilidad d "
	                   + "LEFT JOIN FETCH d.lstTurnos "
	                   + "WHERE s.nombre = :nombre";
	        Query<Servicio> query = session.createQuery(hql, Servicio.class);
	        query.setParameter("nombre", nombreServicio);
	        servicio = query.uniqueResult();
	    } finally {
	        session.close();
	    }
	    return servicio;
	}
	
	
	
	public Disponibilidad traerDisponibilidadConTurnosPorServicio(String nombreServicio, int idDisponibilidad) {
	    Disponibilidad disponibilidad = null;
	    try {
	        iniciaOperacion();
	        String hql = "SELECT d FROM Servicio s " +
	                     "JOIN s.lstDisponibilidad d " +
	                     "LEFT JOIN FETCH d.lstTurnos " +
	                     "WHERE s.nombre = :nombreServicio AND d.idDisponibilidad = :idDisp";

	        Query<Disponibilidad> query = session.createQuery(hql, Disponibilidad.class);
	        query.setParameter("nombreServicio", nombreServicio);
	        query.setParameter("idDisp", idDisponibilidad);

	        disponibilidad = query.uniqueResult();
	    } finally {
	        session.close();
	    }
	    return disponibilidad;
	}

}
