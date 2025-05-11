package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

import datos.Cliente;
import datos.Disponibilidad;
import datos.EstadoTurno;
import datos.Servicio;
import datos.Turno;
import datos.EnumDias;

import negocio.ClienteABM;
import negocio.DisponibilidadABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class TestGuardarTurno {
    public static void main(String[] args) {
        try {
            // Instanciamos los ABM
            ClienteABM clienteABM = new ClienteABM();
            ServicioABM servicioABM = new ServicioABM();
            DisponibilidadABM disponibilidadABM = new DisponibilidadABM();
            TurnoABM turnoABM = new TurnoABM();

            // 1. Crear y guardar Cliente
            int idCliente = clienteABM.agregar("cxxxxstex@mail.com", "1234", 91111111L, "Jusansddesto01", "Xassddsdsad");
            Cliente cliente = clienteABM.traer(idCliente);

            // 2. Crear y guardar Servicio
            // OJO: el método crearServicio requiere un Prestador, que deberías tener cargado.
            // Por ahora asumo que ya tenés uno con ID = 12
            datos.Prestador prestador = new datos.Prestador();
            prestador.setIdUsuario(12); // ID del prestador existente
            int idServicio = servicioABM.crearServicio("gggrgeswwrg", "Gedswadsssdadneral3232", 30, 2500, prestador);
            Servicio servicio = servicioABM.traerServicio(idServicio);

            // 3. Crear y guardar Disponibilidad
            int idDisponibilidad = disponibilidadABM.agregar(EnumDias.LUNES, LocalTime.of(10, 0), LocalTime.of(11, 0));
            Disponibilidad disponibilidad = disponibilidadABM.traer(idDisponibilidad);

            // 4. Crear Turno
            Turno turno = new Turno(
                LocalDate.now().plusDays(1),
                LocalTime.of(10, 0),
                EstadoTurno.PENDIENTE,
                cliente,
                disponibilidad,
                servicio
            );
            
         // Relación bidireccional necesaria para Hibernate
            if (disponibilidad.getLstTurnos() == null) {
                disponibilidad.setLstTurnos(new HashSet<>());
            }
            disponibilidad.getLstTurnos().add(turno);
            turno.setDisponibilidad(disponibilidad);


            // 5. Guardar turno
            int idTurno = turnoABM.agregarTurno(turno);
            System.out.println("✅ Turno guardado con ID: " + idTurno);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

