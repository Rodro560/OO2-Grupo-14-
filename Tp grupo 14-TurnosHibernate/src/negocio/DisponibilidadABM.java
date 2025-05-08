package negocio;

import java.time.LocalTime;

import dao.DisponibilidadDao;
import datos.Disponibilidad;
import datos.EnumDias;


public class DisponibilidadABM {
	
	DisponibilidadDao dao= new DisponibilidadDao();
	
	
	
	public Disponibilidad traerDisponibilidad(int idDisponibilida) {
		return dao.traer(idDisponibilida);
	}
	
	public int generarDisponibilidad(EnumDias diaSemana, LocalTime horaInicio, LocalTime horaFin) throws Exception {
		
		Disponibilidad d= new Disponibilidad(diaSemana, horaInicio, horaFin);
		
		if(horaInicio == null) {
			throw new Exception("La hora de inicio no puede estar vacia");
		}
		
		if (horaFin == null) {
		    throw new Exception("La hora del fin no puede ser vacia.");
		}
		
		System.out.println("Se agrego La disponibilidad");
		return dao.agregar(d);
	}

}
