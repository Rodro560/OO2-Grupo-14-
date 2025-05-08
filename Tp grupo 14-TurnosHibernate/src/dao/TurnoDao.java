package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import datos.EstadoTurno;
import datos.Turno;

public class TurnoDao {

	public Turno obtenerTurnoPorId(int id) throws Exception {
		Turno turno = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			turno = session.get(Turno.class, id);
		} catch (HibernateException e) {
			throw new Exception("Error al obtener turno: " + e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return turno;
	}

	public void guardarTurno(Turno turno) throws Exception {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(turno);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new Exception("Error al guardar turno: " + e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//Modificar un turno existente
	public void actualizarTurno(Turno turno) throws Exception {
	    Transaction tx = null;
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();
	        session.update(turno);
	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        throw new Exception("Error al actualizar turno: " + e.getMessage(), e);
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}
	
	// Consulta por atributos
	public List<Turno> obtenerTurnosPorEstado(EstadoTurno estado) throws Exception {
	    Session session = null;
	    List<Turno> turnos = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        turnos = session.createQuery("FROM Turno t WHERE t.estado = :estado", Turno.class)
	                        .setParameter("estado", estado)
	                        .list();
	    } catch (HibernateException e) {
	        throw new Exception("Error al buscar turnos por estado: " + e.getMessage(), e);
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return turnos;
	}



	public List<Turno> obtenerTodosLosTurnos() throws Exception {
		List<Turno> turnos = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			turnos = session.createQuery("FROM Turno", Turno.class).list();
		} catch (HibernateException e) {
			throw new Exception("Error al obtener todos los turnos: " + e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return turnos;
	}
	
	public void eliminarTurno(int id) throws Exception {
	    Transaction tx = null;
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();
	        Turno turno = session.get(Turno.class, id);
	        if (turno != null) {
	            session.delete(turno);
	            tx.commit();
	        } else {
	            throw new Exception("Error: No se encontró el turno con ID " + id);
	        }
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        throw new Exception("Error al eliminar turno: " + e.getMessage(), e);
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

	
}