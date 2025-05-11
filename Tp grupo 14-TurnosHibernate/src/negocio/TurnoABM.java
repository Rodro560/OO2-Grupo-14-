package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.TurnoDao;
import datos.Cliente;
import datos.Disponibilidad;
import datos.EstadoTurno;
import datos.Servicio;
import datos.Turno;

public class TurnoABM {

	private TurnoDao turnoDAO = new TurnoDao();

	public Turno obtenerTurno(int id) throws Exception {
		Turno turno = turnoDAO.obtenerTurnoPorId(id);
		if (turno == null) {
			throw new Exception("Error: No se encontró un turno con ID " + id);
		}
		return turno;
	}
	
	public int agregarTurno(Turno turno) throws Exception {
        if (turno == null) {
            throw new Exception("El turno no puede ser null.");
        }
        turnoDAO.guardarTurno(turno);
        return turno.getIdTurno();
    }
	

	public int agregarTurno(LocalDate fecha, LocalTime hora, EstadoTurno estado, Cliente cliente,
			Disponibilidad disponibilidad, Servicio servicio) throws Exception {
		if (fecha == null || hora == null || estado == null || cliente == null || disponibilidad == null
				|| servicio == null) {
			throw new Exception("Todos los campos del turno deben estar completos.");
		}

		Turno turno = new Turno(fecha, hora, estado, cliente, disponibilidad, servicio);
		turnoDAO.guardarTurno(turno);
		return turno.getIdTurno();
	}

	public List<Turno> listarTurnos() throws Exception {
		List<Turno> turnos = turnoDAO.obtenerTodosLosTurnos();
		if (turnos == null || turnos.isEmpty()) {
			throw new Exception("Error: No se encontraron turnos.");
		}
		return turnos;
	}

	public void eliminarTurno(int id) throws Exception {
        Turno t = turnoDAO.obtenerTurnoPorId(id);
        if (t == null) {
            throw new Exception("No se puede eliminar: turno con ID " + id + " no existe.");
        }
        turnoDAO.eliminarTurno(id);
    }

	public void actualizarTurno(Turno turno) throws Exception {
        if (turno == null || turno.getIdTurno() == 0) {
            throw new Exception("Turno inválido para actualizar.");
        }
        turnoDAO.actualizarTurno(turno);
    }

	public List<Turno> traerTurnosPorEstado(EstadoTurno estado) throws Exception {
		List<Turno> turnos = turnoDAO.obtenerTurnosPorEstado(estado);
		if (turnos == null || turnos.isEmpty()) {
			throw new Exception("No se encontraron turnos con estado: " + estado);
		}
		return turnos;
	}
}
