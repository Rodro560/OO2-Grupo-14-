package negocio;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import dao.HibernateUtil;
import dao.PerfilDao;
import datos.Cliente;
import datos.Perfil;

public class PerfilABM {

    private PerfilDao perfilDao = new PerfilDao();

    public Perfil obtenerPerfil(int idPerfil) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Perfil perfil = session.get(Perfil.class, idPerfil);

        if (perfil == null) {
            session.close();
            throw new Exception("Error: No se encontró un perfil con ID " + idPerfil);
        }

        // Inicializar usuario antes de devolver el perfil
        Hibernate.initialize(perfil.getUsuario());

        session.close();
        return perfil;
    }
    
    public Perfil crearPerfil(String telefono, String direccion, int idCliente) throws Exception {
        ClienteABM clienteABM = new ClienteABM();
        Cliente cliente = clienteABM.traer(idCliente); // Buscar cliente por ID

        if (cliente == null) {
            throw new Exception("Error: No existe un cliente con ID " + idCliente);
        }

        Perfil perfil = new Perfil(telefono, direccion, cliente);
        perfilDao.guardarPerfil(perfil);
        System.out.println("Perfil creado correctamente!");

        return perfil;
    }

    public Perfil modificarPerfil(int idPerfil, String telefono, String direccion) throws Exception {
        Perfil perfil = perfilDao.obtenerPerfilPorId(idPerfil);
        
        if (perfil == null) {
            throw new Exception("Error: No se encontró un perfil con ID " + idPerfil);
        }

        // Solo actualizar si los valores no son nulos ni vacios
        if (telefono != null && !telefono.trim().isEmpty()) {
            perfil.setTelefono(telefono);
        }
        if (direccion != null && !direccion.trim().isEmpty()) {
            perfil.setDireccion(direccion);
        }

        perfilDao.modificarPerfil(perfil);
        System.out.println("Perfil actualizado correctamente!");

        return perfil;
    }


	public void agregarPerfil(Perfil perfil) throws Exception {
		if (perfil.getUsuario() == null) {
			throw new Exception(" Error: El perfil debe estar asociado a un usuario.");
		}
		perfilDao.guardarPerfil(perfil);
		System.out.println(" Perfil agregado correctamente.");
	}


	public List<Perfil> obtenerTodosLosPerfiles() {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    List<Perfil> perfiles = session.createQuery("FROM Perfil", Perfil.class).list();

	    for (Perfil perfil : perfiles) {
	        Hibernate.initialize(perfil.getUsuario()); // Asegurar que Usuario se carga en la misma sesión
	    }

	    session.close();
	    return perfiles;
	}



    public void eliminarPerfil(int idPerfil) throws Exception {
        perfilDao.eliminarPerfil(idPerfil);
        System.out.println("Perfil eliminado correctamente.");
    }
}
