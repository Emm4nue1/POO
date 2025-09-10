package ar.edu.unju.fi.POO2025.Tp4.models;
import java.util.Date;

public class Reserva {
    public enum ClaseVuelo {
        ECONOMY, BUSINESS
    }

    public enum EstadoReserva {
        RESERVADA, CANCELADA, PAGADA
    }

    private int id;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaRegreso;
    private ClaseVuelo clase;
    private EstadoReserva estado;
    private Pasajero pasajero;

    public Reserva(int id, String origen, String destino, Date fechaSalida, Date fechaRegreso, ClaseVuelo clase, EstadoReserva estado, Pasajero pasajero) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.clase = clase;
        this.estado = estado;
        this.pasajero = pasajero;
    }

    // --- Getters & Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public ClaseVuelo getClase() {
        return clase;
    }

    public void setClase(ClaseVuelo clase) {
        this.clase = clase;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
}
