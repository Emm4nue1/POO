package ar.edu.unju.fi.POO2025.Tp3.punto2;

import ar.edu.unju.fi.POO2025.Tp3.punto2.model.Agencia;
import ar.edu.unju.fi.POO2025.Tp3.punto2.model.Responsable;
import ar.edu.unju.fi.POO2025.Tp3.punto2.model.cars.Camion;
import ar.edu.unju.fi.POO2025.Tp3.punto2.model.cars.Tractor;

import java.time.LocalDate;

public class MainAgencia {
    public static void main(String[] args) {
        // i. Instanciar una agencia
        Agencia agencia = new Agencia();

        // ii. Registrar alquileres
        // Crear vehículos
        Camion camion1 = new Camion("MSR432", 34.29); // 1200 / 35 = ~34.29
        Tractor tractor1 = new Tractor("TDSS40", 520); // 2600 / 5 = 520

        agencia.agregarVehiculo(camion1);
        agencia.agregarVehiculo(tractor1);

        // Alquilar camión
        Responsable responsable1 = agencia.getManagerResponsable().buscarResponsable("12345678");
        camion1.alquilar(responsable1);
        camion1.setKmInicial(100);
        camion1.setKmFinal(135); // 35 km

        // Alquilar tractor
        Responsable responsable2 = agencia.getManagerResponsable().buscarResponsable("23456789");
        tractor1.alquilar(responsable2);
        tractor1.setFechas(LocalDate.now().minusDays(5), LocalDate.now()); // 5 días

        // iii. Buscar y devolver vehículo
        System.out.println("Devolución de vehículos:");
        agencia.devolverVehiculo("MSR432");
        agencia.devolverVehiculo("TDSS40");

        // iv. Mostrar total acumulado
        System.out.println("\nImporte total acumulado: " + agencia.getTotalAcumulado() + "$");
    }
}