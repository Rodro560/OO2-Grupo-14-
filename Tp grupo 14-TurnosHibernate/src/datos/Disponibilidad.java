package datos;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Disponibilidad {
	
	private int idDisponibilidad;
	private EnumDias diaSemana;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Set<Servicio> lstServicios;
	private Set<Turno> lstTurnos;
	
	public Disponibilidad() {}

	public Disponibilidad(EnumDias diaSemana, LocalTime horaInicio, LocalTime horaFin) {
		super();
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.lstServicios= new HashSet<Servicio>();
		this.lstTurnos= new HashSet<Turno>();
	}

	public int getIdDisponibilidad() {
		return idDisponibilidad;
	}

	public void setIdDisponibilidad(int idDisponibilidad) {
		this.idDisponibilidad = idDisponibilidad;
	}

	public EnumDias getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(EnumDias diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Set<Servicio> getLstServicios() {
		return lstServicios;
	}

	public void setLstServicios(Set<Servicio> lstServicios) {
		this.lstServicios = lstServicios;
	}

	public Set<Turno> getLstTurnos() {
		return lstTurnos;
	}

	public void setLstTurnos(Set<Turno> lstTurnos) {
		this.lstTurnos = lstTurnos;
	}

	@Override
	public String toString() {
		return "Disponibilidad [idDisponibilidad=" + idDisponibilidad + ", diaSemana=" + diaSemana + ", horaInicio="
				+ horaInicio + ", horaFin=" + horaFin + "]";
	}
	
	

}
