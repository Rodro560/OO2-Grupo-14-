package test;

import datos.Servicio;
import negocio.ServicioABM;

public class testServicioAbm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServicioABM servicio= new ServicioABM();
		
		try {
			servicio.crearServicio("Servicio 1", "Es el servicio 1", 0, 10.50f, null, null);
			servicio.crearServicio("Servicio 2", "Es el servicio 2", 0, 10.50f, null, null);
			servicio.crearServicio("Servicio 3", "Es el servicio 3", 0, 10.50f, null, null);
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
		

	}

}
