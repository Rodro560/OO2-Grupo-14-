package test;

import java.util.Set;

import datos.Disponibilidad;
import datos.Turno;

public class TestUtils {

	public static void mostrarDisponibilidades(Set<Disponibilidad> disponibilidades) {
		if (disponibilidades == null || disponibilidades.isEmpty()) {
			System.out.println("No hay disponibilidades.");
			return;
		}
		for (Disponibilidad d : disponibilidades) {
			System.out.println(d);
		}
	}

	public static void mostrarTurnos(Set<Turno> turnos) {
		if (turnos == null || turnos.isEmpty()) {
			System.out.println("No hay turnos.");
			return;
		}
		for (Turno t : turnos) {
			System.out.println(t);
		}
	}
	
	public static void mostrarDisponibilidadesConTurnos(Set<Disponibilidad> disponibilidades) {
		if (disponibilidades == null || disponibilidades.isEmpty()) {
			System.out.println("No hay disponibilidades.");
			return;
		}
		for (Disponibilidad d : disponibilidades) {
			System.out.println(d); 
			mostrarTurnos(d.getLstTurnos()); 
		}
	}
	
	public static void mostrarDisponibilidadConTurnos(Disponibilidad disponibilidad) {
        if (disponibilidad == null) {
            System.out.println("No hay disponibilidad.");
            return;
        }
        System.out.println(disponibilidad);  
        mostrarTurnos(disponibilidad.getLstTurnos()); 
    }
}