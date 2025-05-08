package test;

import java.util.List;

import datos.Prestador;
import datos.Servicio;
import negocio.ServicioABM;
import negocio.DisponibilidadABM;
import negocio.EspecificacionABM;
import negocio.PrestadorABM;

public class testServicioAbm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServicioABM servicio= new ServicioABM();
		PrestadorABM prestador= new PrestadorABM();
		DisponibilidadABM disponibilidad= new DisponibilidadABM();
		EspecificacionABM especificacion= new EspecificacionABM();
		
		try {
			servicio.crearServicio("Servicio 1", "Es el servicio 1", 0, 10.50f, prestador.traerPrestador("buenas"), especificacion.traerEspecificaion(1));
			servicio.crearServicio("Servicio 2", "Es el servicio 2", 0, 10.50f, prestador.traerPrestador("buenas"), especificacion.traerEspecificaion(2));
			servicio.crearServicio("Servicio 3", "Es el servicio 3", 0, 10.50f, prestador.traerPrestador("ghrg"), especificacion.traerEspecificaion(3));
			servicio.crearServicio("Servicio 4", "Es el servicio 4", 0, 10.50f, prestador.traerPrestador("buenas"), null);
			servicio.eliminarServicio(servicio.traerServicio("Servicio 2").getIdServicio());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			Servicio s = servicio.traerServicio("Servicio 1");
			s.setNombre("Servicio 2");
			servicio.modificarServicio(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			Prestador p = prestador.traerPrestador("buenas");
		
			List<Servicio> serviciosDelPrestador = servicio.traerServiciosPorPrestador(p);

			for (Servicio s : serviciosDelPrestador) {
				System.out.println("Servicio: " + s.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			servicio.agregarDisponibilidad(servicio.traerServicio("Servicio 2"), disponibilidad.traer(7));
			servicio.agregarDisponibilidad(servicio.traerServicio("Servicio 2"), disponibilidad.traer(8));
			servicio.agregarDisponibilidad(servicio.traerServicio("Servicio 2"), disponibilidad.traer(9));
			servicio.agregarDisponibilidad(servicio.traerServicio("Servicio 3"), disponibilidad.traer(8));
			servicio.agregarDisponibilidad(servicio.traerServicio("Servicio 3"), disponibilidad.traer(9));
			servicio.eliminarDisponibilidad(servicio.traerServicio("Servicio 2"), disponibilidad.traer(9));
			servicio.eliminarDisponibilidad(servicio.traerServicio("Servicio 2"), disponibilidad.traer(7));
			servicio.agregarDisponibilidad(servicio.traerServicio("Servicio 2"), disponibilidad.traer(7));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			servicio.traerDisponibilidades("Servicio 2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
