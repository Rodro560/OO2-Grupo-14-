package datos;


public class Perfil {
	
	private int idPerfil;
	private int telefono;
	private String direccion;
	private  Usuario usuario;
	
	public Perfil() {}

	public Perfil(int idPerfil, int telefono, String direccion, Usuario usuario) {
		super();
		this.idPerfil = idPerfil;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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
