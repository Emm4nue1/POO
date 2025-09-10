package ar.edu.unju.fi.POO2025.Tp4.models.managers;
import ar.edu.unju.fi.POO2025.Tp4.models.Pasajero;
import ar.edu.unju.fi.POO2025.Tp4.models.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerReserva {
    private final List<Reserva> reservas = new ArrayList<>();

    // Crea reserva sin pasajero secundario
    public boolean crearReserva(int id, String origen, String destino, Date salida, Date regreso, Reserva.ClaseVuelo clase, Pasajero pasajero) {
        if (buscarPorId(id) != null) {
            return false; // Ya existe
        }
        Reserva nueva = new Reserva(id, origen, destino, salida, regreso, clase, Reserva.EstadoReserva.RESERVADA, pasajero);
        return reservas.add(nueva);
    }

    // Crea reserva con pasajero secundario
    public boolean crearReservaConSecundario(int id, String origen, String destino, Date salida, Date regreso, Reserva.ClaseVuelo clase, Pasajero pasajero, Pasajero pasajeroSecundario) {
        if (buscarPorId(id) != null) {
            return false;
        }

        if (pasajeroSecundario.getPassword() != null) {
            return false; // No puede tener contraseña
        }

        pasajero.setPasajeroSecundario(pasajeroSecundario);

        Reserva nueva = new Reserva(id, origen, destino, salida, regreso, clase, Reserva.EstadoReserva.RESERVADA, pasajero);
        return reservas.add(nueva);
    }

    // Busca reserva por ID
    public Reserva buscarPorId(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    // Cancela una reserva
    public boolean cancelar(int id) {
        Reserva reserva = buscarPorId(id);
        if (reserva != null) {
            reserva.setEstado(Reserva.EstadoReserva.CANCELADA);
            return true;
        }
        return false;
    }

    // Filtra reservas por clase
    public List<Reserva> filtrarPorClase(Reserva.ClaseVuelo clase) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getClase() == clase) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    // Obtiene todas las reservas
    public List<Reserva> getTodas() {
        return new ArrayList<>(reservas);
    }
}
