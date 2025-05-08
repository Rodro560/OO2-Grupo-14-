package test;

import negocio.ClienteABM;
import datos.Cliente;

public class TestCliente {
	public static void main(String[] args) {
		ClienteABM clienteABM = new ClienteABM();

		System.out.println("---- AGREGAR CLIENTES ----");
		Cliente cliente1 = null, cliente2 = null, cliente3 = null, cliente4 = null;

		try {
			int id1 = clienteABM.agregar("nuevo_cliente1@example.com", "pass111", 11111111, "Fernando", "Ramirez");
			int id2 = clienteABM.agregar("nuevo_cliente2@example.com", "pass222", 22222222, "Sofia", "Castro");
			int id3 = clienteABM.agregar("nuevo_cliente3@example.com", "pass333", 33333333, "Ricardo", "Vega");
			int id4 = clienteABM.agregar("nuevo_cliente4@example.com", "pass444", 44444444, "Valentina", "Torres");

			cliente1 = clienteABM.traer(id1);
			cliente2 = clienteABM.traer(id2);
			cliente3 = clienteABM.traer(id3);
			cliente4 = clienteABM.traer(id4);

			System.out.println("Cliente agregado: " + cliente1);
			System.out.println("Cliente agregado: " + cliente2);
			System.out.println("Cliente agregado: " + cliente3);
			System.out.println("Cliente agregado: " + cliente4);
		} catch (Exception e) {
			System.out.println("Error al agregar clientes: " + e.getMessage());
		}

		System.out.println("\n---- MODIFICAR CLIENTE ----");
		try {

			int id = 2;
			Cliente clienteModificar = clienteABM.traer(id);
			if (clienteModificar != null) {

				clienteModificar.setApellido("Martínez");
				clienteABM.modificar(clienteModificar);
				System.out.println("Cliente modificado: " + clienteABM.traer(clienteModificar.getIdUsuario()));
			}
		} catch (Exception e) {
			System.out.println("Error al modificar cliente: " + e.getMessage());
		}

		System.out.println("\n---- ELIMINAR CLIENTE ----");
		try {
			int id = 3;
			Cliente clienteEliminar = clienteABM.traer(id);
			if (clienteEliminar != null) {
				clienteABM.eliminar(clienteEliminar.getIdUsuario());
				System.out.println("Cliente eliminado correctamente.");
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar cliente: " + e.getMessage());
		}

		System.out.println("\n---- TRAER CLIENTE POR DNI ----");
		long[] dnis = { 11111111, 22222222, 33333333, 44444444, 45678901 }; // dni de prueba que no existe 45678901
		for (long dni : dnis) {
			try {
				Cliente clienteEncontrado = clienteABM.traerPorDni(dni);
				if (clienteEncontrado != null) {
					System.out.println("Cliente encontrado: " + clienteEncontrado);
				} else {
					System.out.println("No se encontró ningún cliente con DNI: " + dni);
				}
			} catch (Exception e) {
				System.out.println("Error al traer cliente por DNI: " + e.getMessage());
			}
		}
	}
}
