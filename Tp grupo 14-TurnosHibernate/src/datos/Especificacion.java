package datos;

import java.util.Objects;

public class Especificacion {
	
	private long idEspecificacion;
    private EnumRubro rubro;
    private String detalles;
    private String personalInvolucrado;
    
	public Especificacion() {}

	public Especificacion(long idEspecificacion, EnumRubro rubro, String detalles, String personalInvolucrado) {
		super();
		this.idEspecificacion = idEspecificacion;
		this.rubro = rubro;
		this.detalles = detalles;
		this.personalInvolucrado = personalInvolucrado;
		
	}

	public long getIdEspecificacion() {
		return idEspecificacion;
	}

	public void setIdEspecificacion(long idEspecificacion) {
		this.idEspecificacion = idEspecificacion;
	}

	public EnumRubro getRubro() {
		return rubro;
	}

	public void setRubro(EnumRubro rubro) {
		this.rubro = rubro;
	}

	public String getResponsable() {
		return detalles;
	}

	public void setResponsable(String responsable) {
		this.detalles = responsable;
	}

	public String getDetallesDelPersonal() {
		return personalInvolucrado;
	}

	public void setDetallesDelPersonal(String detallesDelPersonal) {
		this.personalInvolucrado = detallesDelPersonal;
	}

	@Override
	public String toString() {
		return "Especificacion [idEspecificacion=" + idEspecificacion + ", rubro=" + rubro + ", responsable="
				+ detalles + ", detallesDelPersonal=" + personalInvolucrado + "]";
	}

	
    
	
    
	
}
