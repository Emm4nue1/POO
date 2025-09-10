package ar.edu.unju.fi.POO2025.Tp3.punto1.models;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.product.ItemCarrito;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.product.Producto;
import ar.edu.unju.fi.POO2025.Tp3.punto1.models.user.Usuario;
import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private final List<ItemCarrito> items;
    private final Usuario usuario;

    public CarritoDeCompras(Usuario usuario) {
        this.items = new ArrayList<>();
        this.usuario = usuario;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (!producto.activo()) {
            System.out.println("El producto " + producto.nombre() + " no está activo.");
            return;
        }

        ItemCarrito itemExistente = buscarItem(producto);
        if (itemExistente != null) {
            itemExistente.actualizarSubTotal(cantidad);
        } else {
            items.add(new ItemCarrito(producto, cantidad));
        }

        usuario.agregarAlCarrito(producto, cantidad);
    }

    private ItemCarrito buscarItem(Producto producto) {
        for (ItemCarrito item : items) {
            if (item.getProducto().sku().equals(producto.sku())) {
                return item;
            }
        }
        return null;
    }

    public void removerProducto(Producto producto) {
        ItemCarrito itemARemover = buscarItem(producto);
        if (itemARemover != null) {
            items.remove(itemARemover);
            System.out.println("Producto " + producto.nombre() + " removido del carrito.");
        } else {
            System.out.println("Producto " + producto.nombre() + " no encontrado en el carrito.");
        }
    }

    public double mostrarImporteTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    public double mostrarImporteTotalConDescuento() {
        double total = mostrarImporteTotal();
        return usuario.getTotalConDescuento(total, items); // 👈 Polimórfico
    }

    public void vaciar() {
        items.clear();
        System.out.println("Carrito vaciado.");
    }

    public void mostrarCarrito() {
        System.out.println("\n--- Carrito de " + usuario.getNombre() + " ---");
        if (items.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        for (ItemCarrito item : items) {
            System.out.println(item);
        }
        System.out.println("Total sin descuento: $" + mostrarImporteTotal());
        System.out.println("Total con descuento: $" + mostrarImporteTotalConDescuento());
    }

    public List<ItemCarrito> getItems() { return items; }
    public Usuario getUsuario() { return usuario; }
}
