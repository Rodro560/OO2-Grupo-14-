package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Disponibilidad;

public class DisponibilidadDao {
	
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
	
	
	
	public int agregar(Disponibilidad objeto) {
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
	
	
	

	
	public Disponibilidad traer(int idDisponibilidad) {
		Disponibilidad objeto=null;
		try {
			iniciaOperacion();
			objeto= (Disponibilidad) session.get(Disponibilidad.class, idDisponibilidad);
		} finally {
			session.close();
		} 
		return objeto;
	}

}
