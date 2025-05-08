package test;

import negocio.DisponibilidadABM;
import datos.Disponibilidad;
import datos.EnumDias;
import java.time.LocalTime;

public class TestDisponibilidad {
	public static void main(String[] args) {
		DisponibilidadABM disponibilidadABM = new DisponibilidadABM();

		System.out.println("---- AGREGAR DISPONIBILIDAD ----");
		Disponibilidad disponibilidad1 = null;
		try {
			System.out.println("Intentando agregar disponibilidad para:" + EnumDias.LUNES); // prueba del lunes
			int id = disponibilidadABM.agregar(EnumDias.LUNES, LocalTime.of(8, 0), LocalTime.of(12, 0));
			disponibilidad1 = disponibilidadABM.traer(id);
			System.out.println("Disponibilidad agregada: " + disponibilidad1);
		} catch (Exception e) {
			System.out.println("Error al agregar disponibilidad: " + e.getMessage());
		}

		System.out.println("\n---- MODIFICAR DISPONIBILIDAD ----");
		try {
			if (disponibilidad1 != null) {
				disponibilidad1.setHoraInicio(LocalTime.of(9, 0));
				disponibilidadABM.modificar(disponibilidad1);
				System.out.println(
						"Disponibilidad modificada: " + disponibilidadABM.traer(disponibilidad1.getIdDisponibilidad()));
			}
		} catch (Exception e) {
			System.out.println("Error al modificar disponibilidad: " + e.getMessage());
		}

		System.out.println("\n---- ELIMINAR DISPONIBILIDAD ----");
		try {
			if (disponibilidad1 != null) {
				disponibilidadABM.eliminar(disponibilidad1.getIdDisponibilidad());
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