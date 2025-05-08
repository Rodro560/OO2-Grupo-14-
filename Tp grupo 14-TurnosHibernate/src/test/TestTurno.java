package test;

import java.time.LocalDate;
import java.time.LocalTime;
import org.hibernate.Transaction;
import org.hibernate.Session;
import dao.HibernateUtil;
import datos.Cliente;
import datos.Disponibilidad;
import datos.EnumDias;
import datos.EstadoTurno;
import datos.Servicio;
import datos.Turno;
import negocio.TurnoABM;
import org.hibernate.HibernateException;


public class TestTurno {

	    public static void main(String[] args) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null;

	        try {
	            tx = session.beginTransaction();

	            // Obtener instancias ya persistidas
	            Cliente cliente = session.get(Cliente.class, 8); // ID existente
	            Servicio servicio = session.get(Servicio.class, 10); // ID existente
	            Disponibilidad disponibilidad = session.get(Disponibilidad.class, 2); // ID existente

	            // Verificaciones básicas (opcional)
	            if (cliente == null || servicio == null || disponibilidad == null) {
	                throw new Exception("Alguna entidad referenciada no existe en la base de datos.");
	            }

	            // Crear el Turno
	            Turno turno = new Turno();
	            turno.setFecha(LocalDate.of(2025, 5, 10));
	            turno.setHora(LocalTime.of(10, 0));
	            turno.setEstado(EstadoTurno.PENDIENTE);
	            turno.setCliente(cliente);
	            turno.setServicio(servicio);
	            turno.setDisponibilidad(disponibilidad);

	            session.save(turno);
	            tx.commit();

	            System.out.println("Turno creado exitosamente con ID: " + turno.getIdTurno());

	        } catch (Exception e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	}

