package ar.edu.unju.fi.POO2025.Tp5.models.client;
import ar.edu.unju.fi.POO2025.Tp5.models.ClienteException;
import ar.edu.unju.fi.POO2025.Tp5.models.Compra;
import ar.edu.unju.fi.POO2025.Tp5.models.Localidad;

public class GrandesCompras extends Cliente {
    private final double porcentajeDescuento;

    public GrandesCompras(String dni, String nombre, String email, String telefono,
                          Localidad localidad, double porcentajeDescuento) throws ClienteException {
        super(dni, nombre, email, telefono, localidad);

        if (porcentajeDescuento < 0 || porcentajeDescuento > 1) {
            throw new ClienteException("El porcentaje de descuento debe estar entre 0 y 1");
        }

        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public void agregarCompra(Compra compra) throws ClienteException {
        if (compra.getImporte() <= 0) {
            throw new ClienteException("El importe debe ser mayor que cero");
        }
        compras.add(compra);
    }

    public double aplicarDescuento(double importe) {
        return importe * (1 - porcentajeDescuento);
    }

    // Getters específicos
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
}
