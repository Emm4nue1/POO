package ar.edu.unju.fi.POO2025.Tp4.models;

public class Pasajero {
    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private String password;
    private Pasajero pasajeroSecundario;

    public Pasajero(String nombre, String apellido, int dni, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.password = password;
    }

    public Pasajero(String nombre, String apellido, int dni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
    }

    public Pasajero getPasajeroSecundario() {
        return pasajeroSecundario;
    }

    public void setPasajeroSecundario(Pasajero pasajeroSecundario) {
        if (pasajeroSecundario != null && pasajeroSecundario.getPassword() != null) {
            throw new IllegalArgumentException("El pasajero secundario no puede tener contraseña.");
        }
        this.pasajeroSecundario = pasajeroSecundario;
    }

    public boolean esAuxiliar() {
        return this.password == null;
    }

    // --- Getters & Setters ---
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
