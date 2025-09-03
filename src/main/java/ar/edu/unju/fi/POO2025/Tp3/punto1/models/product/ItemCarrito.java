package ar.edu.unju.fi.POO2025.Tp3.punto1.models.product;

public class ItemCarrito {
    private final Producto producto;
    private double subTotal;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.subTotal = producto.getPrecio() * cantidad;
    }

    public Producto getProducto() { return producto; }
    public double getSubTotal() { return subTotal; }
    public void actualizarSubTotal(int cantidad) {
        this.subTotal = producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "ItemCarrito{producto=" + producto.getNombre() + ", subTotal=" + subTotal + "}";
    }
}