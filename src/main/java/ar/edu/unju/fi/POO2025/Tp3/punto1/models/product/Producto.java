package ar.edu.unju.fi.POO2025.Tp3.punto1.models.product;

public class Producto {
    private final String sku;
    private final String nombre;
    private final double precio;
    private final boolean activo;

    public Producto(String sku, String nombre, double precio, boolean activo) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
    }

    public String getSku() { return sku; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public boolean isActivo() { return activo; }

    @Override
    public String toString() {
        return "Producto{sku='" + sku + "', nombre='" + nombre + "', precio=" + precio + ", activo=" + activo + "}";
    }
}