package negocio;

import java.util.List;
import java.util.Set;

import dao.ServicioDao;
import datos.Servicio;
import datos.Disponibilidad;
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
	
	
	
	public int crearServicio( String nombre, String descripcion, int duracionMin, float precio, Prestador prestador) throws Exception {
		
		Servicio s= new Servicio( nombre, descripcion, duracionMin, precio, prestador, null);
		
		if(traerServicio(nombre)!= null) {
			throw new Exception("El nombre ingresado ya esta registrado");
		}
		
		if (prestador == null) {
		    throw new Exception("Debe asignarse un prestador al servicio.");
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
	
	
	
	public void agregarDisponibilidad(Servicio servicio, Disponibilidad disponibilidad) throws Exception {
	    if (servicio == null) {
	        throw new Exception("El servicio no puede ser null.");
	    }
	    if (disponibilidad == null) {
	        throw new Exception("La disponibilidad no puede ser null.");
	    }
	    if (servicio.getLstDisponibilidad().contains(disponibilidad)) {
	        throw new Exception("La disponibilidad ya está asociada al servicio.");
	    }

	    servicio.getLstDisponibilidad().add(disponibilidad);
	    dao.actualizar(servicio);
	}

	
	
	public void eliminarDisponibilidad(Servicio servicio, Disponibilidad disponibilidad) throws Exception {
	    if (servicio == null) {
	        throw new Exception("El servicio no puede ser null.");
	    }
	    if (disponibilidad == null) {
	        throw new Exception("La disponibilidad no puede ser null.");
	    }
	    if (!servicio.getLstDisponibilidad().contains(disponibilidad)) {
	        throw new Exception("La disponibilidad no está asociada al servicio.");
	    }

	    servicio.getLstDisponibilidad().remove(disponibilidad);
	    dao.actualizar(servicio);
	}
	
	

	public Set<Disponibilidad> traerDisponibilidades(String nombreServicio) throws Exception {
	    Servicio servicio = dao.traerServicio(nombreServicio);

	    if (servicio == null) {
	        throw new Exception("No se encontró un servicio con el nombre: " + nombreServicio);
	    }

	    if (servicio.getLstDisponibilidad().isEmpty()) {
	        throw new Exception("El servicio no tiene disponibilidades asignadas.");
	    }

	    return servicio.getLstDisponibilidad();
	}
	
	
	
	public Set<Disponibilidad> traerDisponibilidadesConTurnos(String nombreServicio) throws Exception {
	    Servicio servicio = dao.traerPorNombreConDisponibilidadesYTurnos(nombreServicio);

	    if (servicio == null) {
	        throw new Exception("No se encontró un servicio con nombre: " + nombreServicio);
	    }

	    if (servicio.getLstDisponibilidad().isEmpty()) {
	        throw new Exception("El servicio no tiene disponibilidades asignadas.");
	    }

	    return servicio.getLstDisponibilidad(); // cada disponibilidad incluirá sus turnos
	}
	
	
	
	public Disponibilidad traerDisponibilidadConTurnos(String nombreServicio, int idDisponibilidad) throws Exception {
	    Disponibilidad d = dao.traerDisponibilidadConTurnosPorServicio(nombreServicio, idDisponibilidad);
	    if (d == null) {
	        throw new Exception("No se encontró la disponibilidad con ID " + idDisponibilidad +" para el servicio '" + nombreServicio + "'");
	    }
	    return d;
	}
}

