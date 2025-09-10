package ar.edu.unju.fi.POO2025.Tp3.punto1.models.product;

public record Producto(String sku, String nombre, double precio, boolean activo) {

    @Override
    public String toString() {
        return "Producto{sku='" + sku + "', nombre='" + nombre + "', precio=" + precio + ", activo=" + activo + "}";
    }
}