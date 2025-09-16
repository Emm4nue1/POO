package ar.edu.unju.fi.POO2025.Tp5.models.client;
import ar.edu.unju.fi.POO2025.Tp5.models.ClienteException;
import ar.edu.unju.fi.POO2025.Tp5.models.Compra;
import ar.edu.unju.fi.POO2025.Tp5.models.Localidad;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    protected String id;
    protected String dni;
    protected String nombre;
    protected String email;
    protected String telefono;
    protected Localidad localidad;
    protected List<Compra> compras;
    private static int contadorId = 1;

    public Cliente(String dni, String nombre, String email, String telefono, Localidad localidad) {
        this.id = "CLI" + String.format("%06d", contadorId++);
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.localidad = localidad;
        this.compras = new ArrayList<>();
    }

    public void agregarCompra(Compra compra) throws ClienteException {
        if (compra.getImporte() <= 0) {
            throw new ClienteException("El importe debe ser mayor que cero");
        }
        compras.add(compra);
    }

    public int getCantidadCompras() {
        return compras.size();
    }

    public double getTotalGastado() {
        return compras.stream().mapToDouble(Compra::getImporte).sum();
    }

    public String getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public List<Compra> getCompras() {
        return new ArrayList<>(compras);
    }
}