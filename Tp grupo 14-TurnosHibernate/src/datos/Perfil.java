package datos;

public class Perfil {
	
	private int idPerfil;
	private int telefono;
	private String direccion;
	private  Usuario usuario;
	
	public Perfil() {}

	public Perfil(int idPerfil, int telefono, String direccion, Cliente cliente) {
		super();
		this.idPerfil = idPerfil;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", telefono=" + telefono + ", direccion=" + direccion + ", cliente="
				+ cliente + "]";
	}

}
