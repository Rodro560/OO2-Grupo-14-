package test;

import negocio.DisponibilidadABM;
import datos.Disponibilidad;
import datos.EnumDias;
import java.time.LocalTime;

public class TestDisponibilidad {
	public static void main(String[] args) {
		DisponibilidadABM disponibilidadABM = new DisponibilidadABM();

		System.out.println("---- AGREGAR DISPONIBILIDAD ----");
		
		Disponibilidad d1 = new Disponibilidad();
		Disponibilidad d2 = new Disponibilidad();
		Disponibilidad d3 = new Disponibilidad();
		Disponibilidad d4 = new Disponibilidad();
		try {
			int id = disponibilidadABM.agregar(EnumDias.LUNES, LocalTime.of(8, 0), LocalTime.of(12, 0));
			int id2 = disponibilidadABM.agregar(EnumDias.MARTES, LocalTime.of(8, 0), LocalTime.of(12, 0));
			int id3= disponibilidadABM.agregar(EnumDias.JUEVES, LocalTime.of(9, 0), LocalTime.of(13, 0));
			int id4 = disponibilidadABM.agregar(EnumDias.VIERNES, LocalTime.of(8, 0), LocalTime.of(12, 0));
			d1 = disponibilidadABM.traer(id);
			d2 = disponibilidadABM.traer(id2);
			d3 = disponibilidadABM.traer(id3);
			d4 = disponibilidadABM.traer(id4);
			System.out.println("Disponibilidad agregada: " + d1);
			System.out.println("Disponibilidad agregada: " + d2);
			System.out.println("Disponibilidad agregada: " + d3);
			System.out.println("Disponibilidad agregada: " + d4);
		} catch (Exception e) {
			System.out.println("Error al agregar disponibilidad: " + e.getMessage());
		}

		System.out.println("\n---- MODIFICAR DISPONIBILIDAD ----");
		try {
			if (d1 != null) {
				d1.setHoraInicio(LocalTime.of(9, 0));
				disponibilidadABM.modificar(d1);
				System.out.println(
						"Disponibilidad modificada: " + disponibilidadABM.traer(d1.getIdDisponibilidad()));
			}
		} catch (Exception e) {
			System.out.println("Error al modificar disponibilidad: " + e.getMessage());
		}

		System.out.println("\n---- ELIMINAR DISPONIBILIDAD ----");
		try {
			if (d1 != null) {
				disponibilidadABM.eliminar(d1.getIdDisponibilidad());
				System.out.println("Disponibilidad eliminada correctamente.");
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar disponibilidad: " + e.getMessage());
		}

		System.out.println("\n---- TRAER TODAS LAS DISPONIBILIDADES ----");
		try {
			if (!disponibilidadABM.traerTodas().isEmpty()) {
				System.out.println("Lista de disponibilidades:");
				for (Disponibilidad d : disponibilidadABM.traerTodas()) {
					System.out.println(d);
				}
			} else {
				System.out.println("No hay disponibilidades registradas.");
			}
		} catch (Exception e) {
			System.out.println("Error al traer todas las disponibilidades: " + e.getMessage());
		}
	}
}