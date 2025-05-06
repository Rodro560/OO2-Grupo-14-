package datos;

import java.util.HashSet;
import java.util.Set;

public class Cliente extends Usuario {
	
	private long dni;
	private String nombre;
	private String apellido;
	private Set<Turno> lstTurnos;
	
	public Cliente() {
		
	}

	public Cliente(int idUsuario, String email, String contrasenia, long dni, String nombre, String apellido) {
		super(idUsuario, email, contrasenia);
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.lstTurnos = new HashSet<Turno>();
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Set<Turno> getLstTurnos() {
		return lstTurnos;
	}

	public void setLstTurnos(Set<Turno> lstTurnos) {
		this.lstTurnos = lstTurnos;
	}

	@Override
	public String toString() {
		return "Cliente ["+super.toString()+"dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
