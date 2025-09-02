package ar.edu.unju.fi.POO2025.Tp3.punto1;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.CarritoDeCompras;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.user.Temporal;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.user.Permanente;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.manager.ManagerProducto;

public class MainEcommerce {
    public static void main(String[] args) {
        // Crear manager de productos
        ManagerProducto manager = new ManagerProducto();

        // Crear usuarios
        Temporal usuarioTemp = new Temporal("T001", "Juan Pérez", "juan@email.com", 50);
        Permanente usuarioPerm = new Permanente("P001", "María García", "maria@email.com", 15.0);

        // Crear carritos
        CarritoDeCompras carritoTemporal = new CarritoDeCompras(usuarioTemp);
        CarritoDeCompras carritoPermanente = new CarritoDeCompras(usuarioPerm);

        System.out.println("=== DEMOSTRACIÓN DEL SISTEMA ECOMMERCE ===");

        // Mostrar productos disponibles
        manager.mostrarProductos();

        // Operaciones con usuario temporal
        System.out.println("\n=== OPERACIONES CON USUARIO TEMPORAL ===");
        carritoTemporal.agregarProducto(manager.buscarProductoPorSku("P001"), 1);
        carritoTemporal.agregarProducto(manager.buscarProductoPorSku("P002"), 2);
        carritoTemporal.agregarProducto(manager.buscarProductoPorSku("P003"), 1);
        carritoTemporal.agregarProducto(manager.buscarProductoPorSku("P005"), 3);
        carritoTemporal.mostrarCarrito();

        // Agregar más productos para activar descuento temporal (>4 productos)
        carritoTemporal.agregarProducto(manager.buscarProductoPorSku("P005"), 1);
        System.out.println("\nDespués de agregar más productos:");
        carritoTemporal.mostrarCarrito();

        // Remover producto
        carritoTemporal.removerProducto(manager.buscarProductoPorSku("P002"));
        System.out.println("\nDespués de remover producto:");
        carritoTemporal.mostrarCarrito();

        // Operaciones con usuario permanente
        System.out.println("\n=== OPERACIONES CON USUARIO PERMANENTE ===");
        carritoPermanente.agregarProducto(manager.buscarProductoPorSku("P001"), 1);
        carritoPermanente.agregarProducto(manager.buscarProductoPorSku("P003"), 1);
        carritoPermanente.agregarProducto(manager.buscarProductoPorSku("P005"), 2);
        carritoPermanente.mostrarCarrito();

        // Intentar agregar producto inactivo
        System.out.println("\n=== PRUEBA CON PRODUCTO INACTIVO ===");
        carritoTemporal.agregarProducto(manager.buscarProductoPorSku("P004"), 1);

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}