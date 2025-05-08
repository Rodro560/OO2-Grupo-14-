package negocio;
import dao.EspecificacionDao;
import datos.EnumRubro;
import datos.Especificacion;
import datos.Servicio;

public class EspecificacionABM {
	
	EspecificacionDao dao= new EspecificacionDao();
	
	
	public Especificacion traerEspecificaion(long idEspecificacion) {
		return dao.traer(idEspecificacion);
	}
	
	
	
	public int crearEspecificacion(EnumRubro rubro, String detalles, String personalInvolucrado) throws Exception {
		
		if(rubro == null) {
			throw new Exception("\nEl campo rubro esta vacio");
		}
		
		if(detalles == null) {
			throw new Exception("\nEl campo detalles esta vacio");
		}
		
		if(personalInvolucrado == null) {
			throw new Exception("\nEl campo personal involcrado esta vacio");
		}
		
		Especificacion e= new Especificacion(rubro, detalles, personalInvolucrado);
		
		return dao.agregar(e);
	}
	
	
	
	public void modificarEspecificacion(Especificacion e) throws Exception {
		
		Especificacion aux= traerEspecificaion(e.getIdEspecificacion());
		
		if(aux == null) {
			throw new Exception("\nLa Especificacion ingresada no existe en la bd");
		}
		
		dao.actualizar(e);
	    System.out.println("\nSe modifico la Especificacion");
	}
	
	
	
	public void eliminarEspecificacion(long idEspecificacion) throws Exception {
		
		Especificacion aux = traerEspecificaion(idEspecificacion);
		
		if(aux == null) {
			throw new Exception("\nNo se puede eliminar la especificacion porque no existe");
		}
		
		dao.eliminar(aux);
	    System.out.println("\nSe elimino la especificacion");
	}

}
