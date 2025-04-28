package datos;

import java.util.HashSet;
import java.util.Set;

public class Prestador extends Usuario{
	
	private String razonSocial;
	private String direccionCentral;
	private String habilitado;
	private Set<Servicio> lstServicio;
	
	public Prestador() {}

	public Prestador(int idUsuario, String email, String contrasenia, String razonSocial, String direccionCentral,
			String habilitado) {
		super(idUsuario, email, contrasenia);
		this.razonSocial = razonSocial;
		this.direccionCentral = direccionCentral;
		this.habilitado = habilitado;
		this.lstServicio = new HashSet<Servicio>();
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccionCentral() {
		return direccionCentral;
	}

	public void setDireccionCentral(String direccionCentral) {
		this.direccionCentral = direccionCentral;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	public Set<Servicio> getLstServicio() {
		return lstServicio;
	}

	public void setLstServicio(Set<Servicio> lstServicio) {
		this.lstServicio = lstServicio;
	}

	@Override
	public String toString() {
		return "Prestador [razonSocial=" + razonSocial + ", direccionCentral=" + direccionCentral + ", habilitado="
				+ habilitado + "]";
	}
	
	

}
