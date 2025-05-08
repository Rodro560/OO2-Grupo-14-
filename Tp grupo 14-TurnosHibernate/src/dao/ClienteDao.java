package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;

public class ClienteDao {
    private Session session;
    private Transaction tx;

    // Método para iniciar una operación en Hibernate
    private void iniciarOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Manejo de excepciones en la capa de acceso a datos
    private void manejarExcepcion(HibernateException he) throws Exception {
        if (tx != null) tx.rollback();
        throw new Exception("Error en la capa de datos", he);
    }

    // Método para verificar si un cliente con el mismo DNI ya existe
    public boolean existeClienteConDni(long dni) throws Exception {
        Cliente cliente = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cliente = (Cliente) session.createQuery("FROM Cliente c WHERE c.dni = :dni")
                    .setParameter("dni", dni)
                    .uniqueResult();
        } catch (HibernateException he) {
            manejarExcepcion(he);
        } finally {
            session.close();
        }
        return cliente != null;
    }

    // Método para agregar un cliente
    public int agregar(Cliente cliente) throws Exception {
        if (existeClienteConDni(cliente.getDni())) {
            throw new Exception("Ya existe un cliente con el DNI " + cliente.getDni());
        }

        int id = 0;
        try {
            iniciarOperacion();
            id = (int) session.save(cliente);
            tx.commit();
        } catch (HibernateException he) {
            manejarExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    // Método para actualizar un cliente
    public void actualizar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente a actualizar no puede ser null.");
        }
        try {
            iniciarOperacion();
            session.update(cliente);
            tx.commit();
        } catch (HibernateException he) {
            manejarExcepcion(he);
        } finally {
            session.close();
        }
    }

    // Método para eliminar un cliente
    public void eliminar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente a eliminar no puede ser null.");
        }
        try {
            iniciarOperacion();
            session.delete(cliente);
            tx.commit();
        } catch (HibernateException he) {
            manejarExcepcion(he);
        } finally {
            session.close();
        }
    }

    // Método para traer un cliente por ID (solo lectura, sin transacción)
    public Cliente traer(int idCliente) {
        Cliente cliente = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cliente = session.get(Cliente.class, idCliente);
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.close();
        }
        return cliente;
    }

    // Método para traer un cliente por DNI (solo lectura, sin transacción)
    public Cliente traerPorDni(long dni) {
        Cliente cliente = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cliente = (Cliente) session.createQuery("FROM Cliente c WHERE c.dni = :dni")
                    .setParameter("dni", dni)
                    .uniqueResult();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.close();
        }
        return cliente;
    }

    // Método para traer todos los clientes ordenados por apellido y nombre
    public List<Cliente> traerTodos() {
        List<Cliente> lista = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            lista = session.createQuery("FROM Cliente c ORDER BY c.apellido ASC, c.nombre ASC", Cliente.class)
                    .getResultList();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }
}