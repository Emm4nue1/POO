package ar.edu.unju.fi.POO2025.Tp3.punto2.models.cars;

public class Camion extends Vehiculo {
    private final double precioKm;
    private double kmInicial;
    private double kmFinal;

    public Camion(String matricula, double precioKm) {
        super(matricula);
        this.precioKm = precioKm;
    }

    public void setKmInicial(double kmInicial) {
        this.kmInicial = kmInicial;
    }

    public void setKmFinal(double kmFinal) {
        this.kmFinal = kmFinal;
    }

    @Override
    public double calcularImporte() {
        return (kmFinal - kmInicial) * precioKm;
    }

    @Override
    public double devolver() {
        double importe = calcularImporte();
        this.alquilado = false;
        return importe;
    }

    @Override
    public String toString() {
        return String.format("Vehículo=CAMION, Chapa=%s, Responsable=%s, Cantidad Kilómetros=%.0f, Importe=%.0f$",
                matricula, responsable, (kmFinal - kmInicial), calcularImporte());
    }
}