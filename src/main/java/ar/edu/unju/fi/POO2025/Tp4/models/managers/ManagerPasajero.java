package ar.edu.unju.fi.POO2025.Tp4.models.managers;
import ar.edu.unju.fi.POO2025.Tp4.models.Pasajero;
import java.util.ArrayList;
import java.util.List;

public class ManagerPasajero {
    private final List<Pasajero> pasajeros = new ArrayList<>();

    // Verifica que la contraseña cumpla con los requisitos
    private boolean esPasswordValida(String password) {
        if (password == null || password.length() < 8 || password.length() > 12) {
            return false;
        }
        int mayusculas = 0;
        int numeros = 0;
        for (char letra : password.toCharArray()) {
            if (Character.isUpperCase(letra)) mayusculas++;
            if (Character.isDigit(letra)) numeros++;
        }
        return mayusculas >= 1 && numeros >= 2;
    }

    // Agrega un pasajero principal (con password)
    public boolean agregarPasajero(String nombre, String apellido, int dni, String email, String password) {
        if (buscarPorDNI(dni) != null) {
            return false;
        }
        if (!esPasswordValida(password)) {
            return false;
        }
        Pasajero nuevo = new Pasajero(nombre, apellido, dni, email, password);
        return pasajeros.add(nuevo);
    }

    // Agrega un pasajero secundario (sin password)
    public boolean agregarPasajeroSecundario(String nombre, String apellido, int dni, String email) {
        if (buscarPorDNI(dni) != null) {
            return false;
        }
        Pasajero secundario = new Pasajero(nombre, apellido, dni, email);
        return pasajeros.add(secundario);
    }

    // Busca pasajero por DNI
    public Pasajero buscarPorDNI(int dni) {
        for (Pasajero p : pasajeros) {
            if (p.getDni() == dni) {
                return p;
            }
        }
        return null;
    }

    // Obtiene todos los pasajeros
    public List<Pasajero> getTodos() {
        return new ArrayList<>(pasajeros);
    }

    // Elimina un pasajero
    public boolean eliminar(int dni) {
        Pasajero encontrado = buscarPorDNI(dni);
        if (encontrado != null) {
            return pasajeros.remove(encontrado);
        }
        return false;
    }
}
