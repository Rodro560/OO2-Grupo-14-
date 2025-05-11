package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	
	private int idTurno;
	private LocalDate fecha;
	private LocalTime hora;
	private EstadoTurno estado;
	private Cliente cliente;
	private Disponibilidad disponibilidad;
	private Servicio servicio;
	
	public Turno() {}

	public Turno(LocalDate fecha, LocalTime hora, EstadoTurno estado, Cliente cliente,
			Disponibilidad disponibilidad, Servicio servicio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.cliente = cliente;
		this.disponibilidad = disponibilidad;
		this.servicio = servicio;
	}

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
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

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado
				+ ", cliente=" + cliente + ", disponibilidad=" + disponibilidad +", servicio="+ servicio + "]";
	}
	
	

}
