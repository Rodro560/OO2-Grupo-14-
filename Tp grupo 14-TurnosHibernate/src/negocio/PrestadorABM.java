package negocio;

import dao.PrestadorDao;
import datos.Prestador;


public class PrestadorABM {
	
	PrestadorDao dao= new PrestadorDao();
	
	public Prestador traerPrestador(int idUsuario) {
		return dao.traer(idUsuario);
	}
	
	public Prestador traerPrestador(String razonSocial) {
		return dao.traer(razonSocial);
	}
	
	
	
	public int registrarPrestador(String email, String contrasenia, String razonSocial, String direccionCentral, boolean habilitado) throws Exception {
		
		Prestador p= new Prestador(email, contrasenia, razonSocial, direccionCentral, habilitado);
		
		if(email==null && contrasenia==null) {
			throw new Exception("La contrasenia o el email estan vacios");
		} 
		if(razonSocial==null || traerPrestador(razonSocial) != null) {
			throw new Exception("La razon social esta vacia o esta repetida");
		} 
		return dao.agregar(p);
	} 
	
	
	
	public void modificarPrestador(Prestador p) throws Exception {
	    Prestador original = traerPrestador(p.getIdUsuario());

	    if (original == null) {
	        throw new Exception("\nNo se puede modificar el Prestador porque NO existe en la base de datos");
	    }
	    Prestador otroConMismaRazonSocial = traerPrestador(p.getRazonSocial());
	    if (otroConMismaRazonSocial != null && otroConMismaRazonSocial.getIdUsuario() != p.getIdUsuario()) {
	        throw new Exception("\nYa existe otro Prestador con la razon social: " + p.getRazonSocial());
	    }
	    dao.actualizar(p);
	    System.out.println("\nSe modifico el servicio");
	}
	
	
	
	public void eliminarPrestador(int idUsuario) throws Exception {
	    Prestador p = traerPrestador(idUsuario);

	    if (p == null) {
	        throw new Exception("No se puede eliminar el servicio porque no existe.");
	    }

	    // Validacion por si hay disponibilidades activas 
	    if (p.getLstServicio() != null && !p.getLstServicio().isEmpty()) {
	        throw new Exception("No se puede eliminar el Prestador porque tiene Servicios asociados.");
	    }

	    dao.eliminar(p);
	    System.out.println("\nSe elimino el Prestador");
	}
	

}
