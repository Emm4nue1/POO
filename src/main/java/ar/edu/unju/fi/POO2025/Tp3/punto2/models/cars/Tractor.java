package ar.edu.unju.fi.POO2025.Tp3.punto2.models.cars;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tractor extends Vehiculo {
    private double precioDia;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Tractor(String matricula, double precioDia) {
        super(matricula);
        this.precioDia = precioDia;
    }

    public void setFechas(LocalDate fechaAlquiler, LocalDate fechaDevolucion) {
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public double calcularImporte() {
        long dias = ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);
        return dias * precioDia;
    }

    @Override
    public double devolver() {
        this.fechaDevolucion = LocalDate.now();
        double importe = calcularImporte();
        this.alquilado = false;
        return importe;
    }

    @Override
    public String toString() {
        long dias = ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);
        return String.format("Vehículo=TRACTOR, Chapa=%s, Responsable=%s, Cantidad Días=%d, Importe=%.0f$",
                matricula, responsable, dias, calcularImporte());
    }
}