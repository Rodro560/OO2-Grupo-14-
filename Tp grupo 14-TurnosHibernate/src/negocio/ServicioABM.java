package negocio;

import java.util.List;

import dao.ServicioDao;
import datos.Servicio;
import datos.Especificacion;
import datos.Prestador;



public class ServicioABM {
	
	ServicioDao dao= new ServicioDao();
	
	public Servicio traerServicio(long idServicio) {
		return dao.traer(idServicio);
	}
	
	public Servicio traerServicio(String nombre) {
		return dao.traerServicio(nombre);
	}
	
	
	public int crearServicio( String nombre, String descripcion, int duracionMin, float precio, Prestador prestador, Especificacion especificacion) throws Exception {
		
		Servicio s= new Servicio( nombre, descripcion, duracionMin, precio, prestador, especificacion);
		
		if(traerServicio(nombre)!= null) {
			throw new Exception("El nombre ingresado ya esta registrado");
		}
		
		System.out.println("Se agrego el servicio");
		return dao.agregar(s);
	}
	
	
	
	public List<Servicio> traerServiciosPorPrestador(Prestador p){
		return dao.traerServiciosPorPrestador(p.getIdUsuario());
	}
	
	
	
	public void modificarServicio(Servicio s) throws Exception {
	    Servicio original = traerServicio(s.getIdServicio());

	    if (original == null) {
	        throw new Exception("\nNo se puede modificar el servicio porque NO existe en la base de datos");
	    }
	    Servicio otroConMismoNombre = traerServicio(s.getNombre());
	    if (otroConMismoNombre != null && otroConMismoNombre.getIdServicio() != s.getIdServicio()) {
	        throw new Exception("\nYa existe otro servicio con el nombre: " + s.getNombre());
	    }
	    dao.actualizar(s);
	    System.out.println("\nSe modifico el servicio");
	}
	
	
	
	public void eliminarServicio(long idServicio) throws Exception {
	    Servicio s = traerServicio(idServicio);

	    if (s == null) {
	        throw new Exception("No se puede eliminar el servicio porque no existe.");
	    }

	    // Validacion por si hay disponibilidades activas 
	    if (s.getLstDisponibilidad() != null && !s.getLstDisponibilidad().isEmpty()) {
	        throw new Exception("No se puede eliminar el servicio porque tiene disponibilidades asociadas.");
	    }

	    dao.eliminar(s);
	    System.out.println("\nSe elimino el servicio");
	}
}
