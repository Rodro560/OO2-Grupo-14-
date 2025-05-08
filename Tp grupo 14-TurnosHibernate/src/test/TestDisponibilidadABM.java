package test;

import java.time.LocalTime;

import datos.Disponibilidad;
import datos.EnumDias;
import negocio.DisponibilidadABM;

public class TestDisponibilidadABM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DisponibilidadABM disponibilidadABM= new DisponibilidadABM();
		
		Disponibilidad d = new Disponibilidad(EnumDias.LUNES, LocalTime.of(3, 0), LocalTime.of(23, 59));
		System.out.println("Intentando guardar: " + d.getDiaSemana()); // Debería imprimir LUNES
		
		try {
			disponibilidadABM.generarDisponibilidad(EnumDias.LUNES, LocalTime.of(3, 0), LocalTime.of(23, 59));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
