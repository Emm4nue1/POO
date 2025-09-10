package ar.edu.unju.fi.POO2025.Tp3.punto1.models.user;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.product.Producto;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.product.ItemCarrito;
import java.util.List;

public class Permanente extends Usuario {
    private double porcentajeDescuento;

    public Permanente(String id, String nombre, String email, double porcentajeDescuento) {
        super(id, nombre, email);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Permanente() {
    }

    public double getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(double porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }

    @Override
    public void agregarAlCarrito(Producto producto, int cantidad) {
        System.out.println("Usuario permanente agregando producto: " + producto.nombre());
    }

    @Override
    public double getTotalConDescuento(double total, List<ItemCarrito> items) {
        return total - (total * porcentajeDescuento / 100);
    }
}
