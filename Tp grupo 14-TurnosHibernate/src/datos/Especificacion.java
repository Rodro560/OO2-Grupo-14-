package datos;

public class Especificacion {
	
	private int idEspecificacion;
    private EnumRubro rubro;
    private String detalles;
    private String personalInvolucrado;
    private Servicio servicio;
    
	public Especificacion() {}

	public Especificacion(int idEspecificacion, EnumRubro rubro, String detalles, String personalInvolucrado, Servicio servicio) {
		super();
		this.idEspecificacion = idEspecificacion;
		this.rubro = rubro;
		this.detalles = detalles;
		this.personalInvolucrado = personalInvolucrado;
		this.servicio = servicio;
	}

	public int getIdEspecificacion() {
		return idEspecificacion;
	}

	public void setIdEspecificacion(int idEspecificacion) {
		this.idEspecificacion = idEspecificacion;
	}

	public EnumRubro getRubro() {
		return rubro;
	}

	public void setRubro(EnumRubro rubro) {
		this.rubro = rubro;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getPersonalInvolucrado() {
		return personalInvolucrado;
	}

	public void setPersonalInvolucrado(String personalInvolucrado) {
		this.personalInvolucrado = personalInvolucrado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Especificacion [idEspecificacion=" + idEspecificacion + ", rubro=" + rubro + ", detalles=" + detalles
				+ ", personalInvolucrado=" + personalInvolucrado + ", servicio=" + servicio + "]";
	}

	
    
	
}
