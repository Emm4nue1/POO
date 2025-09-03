package ar.edu.unju.fi.POO2025.Tp3.punto2.models;
import ar.edu.unju.fi.POO2025.Tp3.punto2.models.cars.Vehiculo;
import ar.edu.unju.fi.POO2025.Tp3.punto2.models.manager.ManagerResponsable;
import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Vehiculo> vehiculos;
    private double totalAcumulado;
    private final ManagerResponsable managerResponsable;

    public Agencia() {
        vehiculos = new ArrayList<>();
        managerResponsable = new ManagerResponsable();
        totalAcumulado = 0;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                return v;
            }
        }
        return null;
    }

    public double devolverVehiculo(String matricula) {
        Vehiculo vehiculo = buscarVehiculo(matricula);
        if (vehiculo != null && vehiculo.isAlquilado()) {
            double importe = vehiculo.devolver();
            totalAcumulado += importe;
            System.out.println(vehiculo.toString());
            return importe;
        }
        return 0;
    }

    public double getTotalAcumulado() {
        return totalAcumulado;
    }
    public ManagerResponsable getManagerResponsable() {
        return managerResponsable;
    }
}