package datos;

public class Usuario {
	
	protected int idUsuario;
	protected String email;
	protected String contrasenia;
	
	public Usuario() {}

	public Usuario( String email, String contrasenia) {
		super();
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", email=" + email + ", contrasenia=" + contrasenia + "]";
	}
	

}
