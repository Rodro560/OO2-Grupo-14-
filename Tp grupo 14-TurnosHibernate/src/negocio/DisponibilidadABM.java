package negocio;

import java.util.Set;
import java.time.LocalTime;
import java.util.List;
import dao.DisponibilidadDao;
import datos.Disponibilidad;
import datos.EnumDias;
import datos.Servicio;
import datos.Turno;

public class DisponibilidadABM {
	private DisponibilidadDao dao = new DisponibilidadDao();

	// Método para traer una disponibilidad por ID
	public Disponibilidad traer(int idDisponibilidad) throws Exception {
		Disponibilidad disponibilidad = dao.traer(idDisponibilidad);
		if (disponibilidad == null) {
			throw new Exception("No se encontró la disponibilidad con ID " + idDisponibilidad);
		}
		return disponibilidad;
	}

	// Método para agregar una nueva disponibilidad
	public int agregar(EnumDias diaSemana, LocalTime horaInicio, LocalTime horaFin) throws Exception {
		if (horaInicio == null || horaFin == null) {
			throw new Exception("Las horas de inicio y fin no pueden ser null.");
		}

		Disponibilidad disponibilidad = new Disponibilidad(diaSemana, horaInicio, horaFin);
		try {
			return dao.agregar(disponibilidad);
		} catch (Exception e) {
			throw new Exception("Error al agregar la disponibilidad: " + e.getMessage());
		}
	}

	// Método para modificar una disponibilidad
	public void modificar(Disponibilidad disponibilidad) throws Exception {
		if (disponibilidad == null) {
			throw new Exception("La disponibilidad a modificar no puede ser null.");
		}
		dao.actualizar(disponibilidad);
	}

	// Método para eliminar una disponibilidad por ID
	public void eliminar(int idDisponibilidad) throws Exception {
		Disponibilidad disponibilidad = traer(idDisponibilidad);
		if (disponibilidad == null) {
			throw new Exception("No se encontró la disponibilidad con ID " + idDisponibilidad);
		}
		dao.eliminar(disponibilidad);
	}

	// Método para traer todas las disponibilidades
	public List<Disponibilidad> traerTodas() throws Exception {
		List<Disponibilidad> disponibilidades = dao.traerTodas();
		if (disponibilidades == null || disponibilidades.isEmpty()) {
			throw new Exception("No se encontraron disponibilidades.");
		}
		return disponibilidades;
	}

	// Método para agregar un servicio a una disponibilidad
	public void agregarServicio(int idDisponibilidad, Servicio servicio) throws Exception {
		Disponibilidad disponibilidad = traer(idDisponibilidad);
		if (disponibilidad.getLstServicios().contains(servicio)) {
			throw new Exception("El servicio ya está asociado a esta disponibilidad.");
		}
		disponibilidad.getLstServicios().add(servicio);
		modificar(disponibilidad);
	}

	// Método para eliminar un servicio de una disponibilidad
	public void eliminarServicio(int idDisponibilidad, Servicio servicio) throws Exception {
		Disponibilidad disponibilidad = traer(idDisponibilidad);
		if (!disponibilidad.getLstServicios().contains(servicio)) {
			throw new Exception("El servicio no está asociado a esta disponibilidad.");
		}
		disponibilidad.getLstServicios().remove(servicio);
		modificar(disponibilidad);
	}

	// Método para obtener los servicios de una disponibilidad
	public Set<Servicio> traerServicios(int idDisponibilidad) throws Exception {
		Disponibilidad disponibilidad = traer(idDisponibilidad);
		if (disponibilidad.getLstServicios().isEmpty()) {
			throw new Exception("La disponibilidad no tiene servicios asignados.");
		}
		return disponibilidad.getLstServicios();
	}

	// Método para agregar un turno a una disponibilidad
	public void agregarTurno(int idDisponibilidad, Turno turno) throws Exception {
		Disponibilidad disponibilidad = traer(idDisponibilidad);
		if (disponibilidad.getLstTurnos().contains(turno)) {
			throw new Exception("El turno ya está asociado a esta disponibilidad.");
		}
		disponibilidad.getLstTurnos().add(turno);
		modificar(disponibilidad);
	}

	// Método para eliminar un turno de una disponibilidad
	public void eliminarTurno(int idDisponibilidad, Turno turno) throws Exception {
		Disponibilidad disponibilidad = traer(idDisponibilidad);
		if (!disponibilidad.getLstTurnos().contains(turno)) {
			throw new Exception("El turno no está asociado a esta disponibilidad.");
		}
		disponibilidad.getLstTurnos().remove(turno);
		modificar(disponibilidad);
	}

	// Método para obtener los turnos de una disponibilidad
	public Set<Turno> traerTurnos(int idDisponibilidad) throws Exception {
		Disponibilidad disponibilidad = traer(idDisponibilidad);
		if (disponibilidad.getLstTurnos().isEmpty()) {
			throw new Exception("La disponibilidad no tiene turnos asignados.");
		}
		return disponibilidad.getLstTurnos();
	}
}