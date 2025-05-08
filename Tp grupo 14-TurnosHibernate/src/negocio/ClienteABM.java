package negocio;

import java.util.List;
import java.util.Set;
import dao.ClienteDao;
import datos.Cliente;
import datos.Turno;

public class ClienteABM {
    private ClienteDao dao = new ClienteDao();

    // Método para traer un cliente por ID
    public Cliente traer(int idCliente) throws Exception {
        Cliente cliente = dao.traer(idCliente);
        if (cliente == null) {
            throw new Exception("No se encontró el cliente con ID " + idCliente);
        }
        return cliente;
    }

    // Método para traer un cliente por DNI
    public Cliente traerPorDni(long dni) throws Exception {
        Cliente cliente = dao.traerPorDni(dni);
        if (cliente == null) {
            throw new Exception("No se encontró el cliente con DNI " + dni);
        }
        return cliente;
    }

    // Método para agregar un nuevo cliente
    public int agregar(String email, String contrasenia, long dni, String nombre, String apellido) throws Exception {
        // Verificar si ya existe un cliente con el mismo DNI
        if (dao.existeClienteConDni(dni)) {
            throw new Exception("Ya existe un cliente con el DNI " + dni);
        }

        // Crear el cliente
        Cliente c = new Cliente(email, contrasenia, dni, nombre, apellido);

        // Agregar el cliente a la base de datos
        try {
            return dao.agregar(c);
        } catch (Exception e) {
            throw new Exception("Error al agregar el cliente: " + e.getMessage());
        }
    }

    // Método para modificar un cliente
    public void modificar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente a modificar no puede ser null.");
        }
        dao.actualizar(cliente);
    }

    // Método para eliminar un cliente por ID
    public void eliminar(int idCliente) throws Exception {
        Cliente c = dao.traer(idCliente);
        if (c == null) {
            throw new Exception("No se encontró el cliente con ID " + idCliente);
        }
        dao.eliminar(c);
    }

    // Método para traer todos los clientes
    public List<Cliente> traerTodos() throws Exception {
        List<Cliente> clientes = dao.traerTodos();
        if (clientes == null || clientes.isEmpty()) {
            throw new Exception("No se encontraron clientes.");
        }
        return clientes;
    }

    // Método para agregar un turno a un cliente
    public void agregarTurno(int idCliente, Turno turno) throws Exception {
        Cliente cliente = traer(idCliente);
        if (cliente.getLstTurnos().contains(turno)) {
            throw new Exception("El turno ya está asociado a este cliente.");
        }
        cliente.getLstTurnos().add(turno);
        modificar(cliente);
    }

    // Método para eliminar un turno de un cliente
    public void eliminarTurno(int idCliente, Turno turno) throws Exception {
        Cliente cliente = traer(idCliente);
        if (!cliente.getLstTurnos().contains(turno)) {
            throw new Exception("El turno no está asociado a este cliente.");
        }
        cliente.getLstTurnos().remove(turno);
        modificar(cliente);
    }

    // Método para obtener los turnos de un cliente
    public Set<Turno> traerTurnos(int idCliente) throws Exception {
        Cliente cliente = traer(idCliente);
        if (cliente.getLstTurnos().isEmpty()) {
            throw new Exception("El cliente no tiene turnos asignados.");
        }
        return cliente.getLstTurnos();
    }
}