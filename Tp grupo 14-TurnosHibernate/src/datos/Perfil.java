package datos;


public class Perfil {
	
	private int idPerfil;
	private String telefono;
	private String direccion;
	private  Usuario usuario;
	
	public Perfil() {}

	public Perfil(String telefono, String direccion, Usuario usuario) {
	    super();

	    if (usuario == null || usuario.getIdUsuario() == 0) { // Validación extra
	        throw new IllegalArgumentException(" Error: El usuario no puede ser null ni tener ID 0.");
	    }

	    this.idPerfil = usuario.getIdUsuario(); // Asigna el ID desde Usuario
	    this.telefono = telefono;
	    this.direccion = direccion;
	    this.usuario = usuario;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", telefono=" + telefono + ", direccion=" + direccion + ", usuario="
				+ usuario + "]";
	}

}
