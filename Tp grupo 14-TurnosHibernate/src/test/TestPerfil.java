package test;

import datos.Perfil;
import negocio.PerfilABM;

public class TestPerfil {
	public static void main(String[] args) {
		PerfilABM perfilABM = new PerfilABM();

		try {
			System.out.println("--- Creando perfil para cliente	 ---");
			perfilABM.crearPerfil("123456789", "Av. Siempre Viva 742", 1);
		} catch (Exception e) {
			System.err.println(" Error al crear perfil de cliente: " + e.getMessage());
		}

		try {
			System.out.println("--- Creando perfil para prestador	---");
			perfilABM.crearPerfil("987654321", "Calle Falsa 123", 2);
		} catch (Exception e) {
			System.err.println(" Error al crear perfil de prestador: " + e.getMessage());
		}

		try {
			System.out.println("\n--- 	Recuperando perfil	---");
			Perfil perfilRecuperado = perfilABM.obtenerPerfil(1);

			if (perfilRecuperado != null) {
				System.out.printf(" Perfil encontrado: ID=%d, Teléfono=%s, Dirección=%s, Usuario=%s%n",
						perfilRecuperado.getIdPerfil(), perfilRecuperado.getTelefono(), perfilRecuperado.getDireccion(),
						perfilRecuperado.getUsuario());
			} else {
				System.err.println(" Error: No se encontró el perfil con ID 1.");
			}
		} catch (Exception e) {
			System.err.println(" Error al obtener perfil: " + e.getMessage());
		}

		try {
			System.out.println("\n--- Modificando perfil	---");
			perfilABM.modificarPerfil(1, "555444333", "Nueva dirección 123");
		} catch (Exception e) {
			System.err.println(" Error al modificar perfil: " + e.getMessage());
		}

		try {
			System.out.println("\n--- Listando perfiles después de modificación	---");
			for (Perfil p : perfilABM.obtenerTodosLosPerfiles()) {
				System.out.printf(" Perfil: ID=%d, Teléfono=%s, Dirección=%s, Usuario=%s%n", p.getIdPerfil(),
						p.getTelefono(), p.getDireccion(), p.getUsuario());
			}
		} catch (Exception e) {
			System.err.println(" Error al listar perfiles: " + e.getMessage());
		}

		try {
			System.out.println("\n--- Eliminando perfil	---");
			perfilABM.eliminarPerfil(1);
			System.out.println(" Perfil eliminado correctamente!");
		} catch (Exception e) {
			System.err.println(" Error al eliminar perfil: " + e.getMessage());
		}
		
	}
}
