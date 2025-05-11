package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import org.hibernate.Transaction;
import org.hibernate.Session;
import dao.HibernateUtil;
import datos.Cliente;
import datos.Disponibilidad;
import datos.EstadoTurno;
import datos.Servicio;
import datos.Turno;
import negocio.TurnoABM;
import org.hibernate.HibernateException;

public class TestTurno {
	public static void main(String[] args) {
		try {
			TurnoABM abm = new TurnoABM();
			int idTurno = 1; // Asegurate de que este ID exista en la base
			Turno turno = abm.obtenerTurno(idTurno);

			if (turno != null) {
				System.out.println("Turno encontrado:");
				System.out.println("ID: " + turno.getIdTurno());
				System.out.println("Fecha: " + turno.getFecha());
				System.out.println("Hora: " + turno.getHora());
				System.out.println("Estado: " + turno.getEstado());
			} else {
				System.out.println("No se encontró el turno con ID " + idTurno);
			}
		} catch (Exception e) {
			System.out.println("Error al obtener el turno: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
