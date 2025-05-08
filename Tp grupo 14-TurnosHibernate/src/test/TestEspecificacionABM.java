package test;

import datos.EnumRubro;
import datos.Especificacion;
import negocio.EspecificacionABM;

public class TestEspecificacionABM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EspecificacionABM especificacion= new EspecificacionABM();
		
		try {
			especificacion.crearEspecificacion(EnumRubro.MEDICO, "Una especificacion de medico", "Rodrigo" );
			especificacion.crearEspecificacion(EnumRubro.MECANICA, "Una especificacion de Mecanica", "Rodrigo");
			especificacion.crearEspecificacion(EnumRubro.LABORATORIO, "Una especificacion de Laboratorio", "Rodrigo");
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
