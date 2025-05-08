package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import datos.Perfil;

public class PerfilDao {

    public Perfil obtenerPerfilPorId(int idPerfil) throws Exception {
        Perfil perfil = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            perfil = session.get(Perfil.class, idPerfil);
        } catch (HibernateException e) {
            throw new Exception("Error al obtener perfil: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return perfil;
    }

    public void guardarPerfil(Perfil perfil) throws Exception {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(perfil);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw new Exception("Error al guardar perfil: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Perfil> obtenerTodosLosPerfiles() throws Exception {
        List<Perfil> perfiles = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            perfiles = session.createQuery("FROM Perfil", Perfil.class).list();
        } catch (HibernateException e) {
            throw new Exception("Error al obtener todos los perfiles: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return perfiles;
    }
    
    public void modificarPerfil(Perfil perfil) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Perfil perfilExistente = session.get(Perfil.class, perfil.getIdPerfil());

            if (perfilExistente == null) {
                throw new Exception("❌ Error: No se encontró un perfil con ID " + perfil.getIdPerfil());
            }

            perfilExistente.setTelefono(perfil.getTelefono());
            perfilExistente.setDireccion(perfil.getDireccion());
            session.update(perfilExistente);

            tx.commit();
            System.out.println(" Perfil actualizado correctamente!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception(" Error al modificar perfil: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void eliminarPerfil(int idPerfil) throws Exception {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Perfil perfil = session.get(Perfil.class, idPerfil);
            if (perfil != null) {
                session.delete(perfil);
                tx.commit();
            } else {
                throw new Exception("Error: No se encontró el perfil con ID " + idPerfil);
            }
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw new Exception("Error al eliminar perfil: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
