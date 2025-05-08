package negocio;

import java.util.List;

import dao.TurnoDao;
import datos.EstadoTurno;
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

    public void agregarTurno(Turno turno) throws Exception {
        turnoDAO.guardarTurno(turno);
        System.out.println("✅ Turno agregado correctamente.");
    }

    public List<Turno> listarTurnos() throws Exception {
        List<Turno> turnos = turnoDAO.obtenerTodosLosTurnos();
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("Error: No se encontraron turnos.");
        }
        return turnos;
    }

    public void eliminarTurno(int id) throws Exception {
        turnoDAO.eliminarTurno(id);
        System.out.println("✅ Turno eliminado correctamente.");
    }

    public void actualizarTurno(Turno turno) throws Exception {
        turnoDAO.actualizarTurno(turno);
        System.out.println("✅ Turno actualizado correctamente.");
    }

    public List<Turno> traerTurnosPorEstado(EstadoTurno estado) throws Exception {
        List<Turno> turnos = turnoDAO.obtenerTurnosPorEstado(estado);
        if (turnos == null || turnos.isEmpty()) {
            throw new Exception("No se encontraron turnos con estado: " + estado);
        }
        return turnos;
    }
}
