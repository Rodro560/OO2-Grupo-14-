package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	
	private int idTurnos;
	private LocalDate fecha;
	private LocalTime hora;
	private EstadoTurno estado;
	private Cliente cliente;
	private Disponibilidad disponibilidad;
	private Servicio servicio;
	
	public Turno() {}

	public Turno(int idTurnos, LocalDate fecha, LocalTime hora, EstadoTurno estado, Cliente cliente,
			Disponibilidad disponibilidad) {
		super();
		this.idTurnos = idTurnos;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.cliente = cliente;
		this.disponibilidad = disponibilidad;
	}

	public int getIdTurnos() {
		return idTurnos;
	}

	public void setIdTurnos(int idTurnos) {
		this.idTurnos = idTurnos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public EstadoTurno getEstado() {
		return estado;
	}

	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Turno [idTurnos=" + idTurnos + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado
				+ ", cliente=" + cliente + ", disponibilidad=" + disponibilidad + "]";
	}
	
	

}
