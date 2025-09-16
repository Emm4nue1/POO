package ar.edu.unju.fi.POO2025.Tp5.models;
import java.time.LocalDate;

public class Compra {
    private String id;
    private LocalDate fecha;
    private double importe;

    public Compra(String id, LocalDate fecha, double importe) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
    }

    public String getId() {
        return id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public double getImporte() {
        return importe;
    }
}