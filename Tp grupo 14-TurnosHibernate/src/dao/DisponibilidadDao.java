package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Disponibilidad;

public class DisponibilidadDao {
	private static Session session;
	private Transaction tx;

	// Método para iniciar una sesión en Hibernate
	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	// Manejo de excepciones en la capa de datos
	private void manejarExcepcion(HibernateException he) throws Exception {
		if (tx != null) {
			tx.rollback();
		}
		System.out.println("Excepción original: " + he.toString());
		he.printStackTrace(); // Esto imprimirá el stack trace completo
		throw new Exception("Error en la capa de datos", he);
	}

	// Método para agregar una disponibilidad
	public int agregar(Disponibilidad disponibilidad) throws Exception {
		int id = 0;
		try {
			iniciarOperacion();
			id = (int) session.save(disponibilidad);
			tx.commit();
		} catch (HibernateException he) {
			manejarExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	// Método para actualizar una disponibilidad
	public void actualizar(Disponibilidad disponibilidad) throws Exception {
		if (disponibilidad == null) {
			throw new Exception("La disponibilidad no puede actualizarse de manera nula");
		}
		try {
			iniciarOperacion();
			session.update(disponibilidad);
			tx.commit();
		} catch (HibernateException he) {
			manejarExcepcion(he);
		} finally {
			session.close();
		}
	}

	// Método para eliminar una disponibilidad
	public void eliminar(Disponibilidad disponibilidad) throws Exception {
		if (disponibilidad == null) {
			throw new Exception("La disponibilidad a eliminar no puede ser null.");
		}
		try {
			iniciarOperacion();
			session.delete(disponibilidad);
			tx.commit();
		} catch (HibernateException he) {
			manejarExcepcion(he);
		} finally {
			session.close();
		}
	}

	// Método para traer una disponibilidad por ID
	public Disponibilidad traer(int idDisponibilidad) {
		Disponibilidad disponibilidad = null;
		try {
			iniciarOperacion();
			disponibilidad = session.get(Disponibilidad.class, idDisponibilidad);
		} finally {
			session.close();
		}
		return disponibilidad; // Devuelve null si no la encuentra
	}

	// Método para traer todas las disponibilidades
	public List<Disponibilidad> traerTodas() {
		List<Disponibilidad> lista = null;
		try {
			iniciarOperacion();
			lista = session.createQuery("FROM Disponibilidad d ORDER BY d.diaSemana ASC, d.horaInicio ASC",
					Disponibilidad.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}