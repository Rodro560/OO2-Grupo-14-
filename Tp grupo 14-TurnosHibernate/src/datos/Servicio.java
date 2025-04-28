package datos;

import java.util.HashSet;
import java.util.Set;

public class Servicio {
	
	private long idServicio;
	private String nombre;
	private String descripcion;
	private int durecionMin;
	private float precio;
	private Prestador prestador;
	private Set<Disponibilidad> lstDisponibilidad;
	
	public Servicio() {}

	public Servicio(long idServicio, String nombre, String descripcion, int durecionMin, float precio,
			Prestador prestador) {
		super();
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.durecionMin = durecionMin;
		this.precio = precio;
		this.prestador = prestador;
		this.lstDisponibilidad = new HashSet<Disponibilidad>();
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDurecionMin() {
		return durecionMin;
	}

	public void setDurecionMin(int durecionMin) {
		this.durecionMin = durecionMin;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public Set<Disponibilidad> getLstDisponibilidad() {
		return lstDisponibilidad;
	}

	public void setLstDisponibilidad(Set<Disponibilidad> lstDisponibilidad) {
		this.lstDisponibilidad = lstDisponibilidad;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", durecionMin=" + durecionMin + ", precio=" + precio + ", prestador=" + prestador + "]";
	}

}
