package ar.edu.unju.fi.POO2025.Tp3.punto1.models.manager;

import ar.edu.unju.fi.POO2025.Tp3.punto1.models.product.Producto;
import java.util.ArrayList;
import java.util.List;


public class ManagerProducto {
    private List<Producto> productos;

    public ManagerProducto() {
        this.productos = new ArrayList<>();
        inicializarProductos();
    }

    // Inicializar con 5 productos
    private void inicializarProductos() {
        productos.add(new Producto("P001", "Laptop Gaming", 1200.00, true));
        productos.add(new Producto("P002", "Mouse Inalámbrico", 25.50, true));
        productos.add(new Producto("P003", "Teclado Mecánico", 85.75, true));
        productos.add(new Producto("P004", "Monitor 24''", 299.99, false));
        productos.add(new Producto("P005", "Auriculares Bluetooth", 59.99, true));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Producto buscarProductoPorSku(String sku) {
        for (Producto producto : productos) {
            if (producto.getSku().equals(sku)) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        for (Producto producto : productos) {
            if (producto.isActivo()) {
                System.out.println(producto);
            }
        }
    }
}
