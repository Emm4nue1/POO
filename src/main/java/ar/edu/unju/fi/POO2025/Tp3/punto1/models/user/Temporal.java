package ar.edu.unju.fi.POO2025.Tp3.punto1.models.user;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.product.Producto;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.product.ItemCarrito;
import java.util.List;

public class Temporal extends Usuario {
    private int descuentoCantidad;

    public Temporal(String id, String nombre, String email, int descuentoCantidad) {
        super(id, nombre, email);
        this.descuentoCantidad = descuentoCantidad;
    }

    public Temporal() {
    }

    public int getDescuentoCantidad() { return descuentoCantidad; }
    public void setDescuentoCantidad(int descuentoCantidad) { this.descuentoCantidad = descuentoCantidad; }

    @Override
    public void agregarAlCarrito(Producto producto, int cantidad) {
        System.out.println("Usuario temporal agregando producto: " + producto.nombre());
    }

    @Override
    public double getTotalConDescuento(double total, List<ItemCarrito> items) {
        if (items.size() > 4) {
            total -= descuentoCantidad;
        }
        return total;
    }
}
