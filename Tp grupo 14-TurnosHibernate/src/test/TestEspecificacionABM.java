package test;

import datos.EnumRubro;
import datos.Especificacion;
import negocio.EspecificacionABM;
import negocio.ServicioABM;

public class TestEspecificacionABM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EspecificacionABM especificacion= new EspecificacionABM();
		ServicioABM servicio= new ServicioABM();
		
		try {
			especificacion.crearEspecificacion(EnumRubro.BELLEZA, "Una especificacion de belleza", "Brenda", servicio.traerServicio("Servicio 2") );
			especificacion.crearEspecificacion(EnumRubro.GASTRONOMIA, "Una especificacion de gastronomia", "Rodrigo", servicio.traerServicio("Servicio 3"));
			especificacion.crearEspecificacion(EnumRubro.MECANICA, "Una especificacion de Laboratorio", "Nico", servicio.traerServicio("Servicio 4"));
			especificacion.eliminarEspecificacion(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Especificacion e= especificacion.traerEspecificaion(1);
		e.setRubro(EnumRubro.LABORATORIO);
		
		try {
			especificacion.modificarEspecificacion(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};

	}

}
