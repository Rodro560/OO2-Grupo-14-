package datos;

import java.util.HashSet;
import java.util.Set;

public class Servicio {
	
	private long idServicio;
	private String nombre;
	private String descripcion;
	private int duracionMin;
	private float precio;
	private Prestador prestador;
	private Especificacion especificacion;
	private Set<Disponibilidad> lstDisponibilidad;
	
	public Servicio() {}

	public Servicio(long idServicio, String nombre, String descripcion, int duracionMin, float precio,
			Prestador prestador, Especificacion especificacion) {
		super();
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionMin = duracionMin;
		this.precio = precio;
		this.prestador = prestador;
		this.especificacion=especificacion;
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

	public int getDuracionMin() {
		return duracionMin;
	}

	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
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

	public Especificacion getEspecificacion() {
		return especificacion;
	}

	public void setEspecificacion(Especificacion especificacion) {
		this.especificacion = especificacion;
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
				+ ", duracionMin=" + duracionMin + ", precio=" + precio + ", prestador=" + prestador +especificacion.toString()+ "]";
	}

}
