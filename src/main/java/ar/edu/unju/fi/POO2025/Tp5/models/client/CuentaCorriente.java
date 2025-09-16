package ar.edu.unju.fi.POO2025.Tp5.models.client;
import ar.edu.unju.fi.POO2025.Tp5.models.ClienteException;
import ar.edu.unju.fi.POO2025.Tp5.models.Compra;
import ar.edu.unju.fi.POO2025.Tp5.models.Localidad;

public class CuentaCorriente extends Cliente {
    private final double limiteMensual;
    private double gastosMesActual;

    public CuentaCorriente(String dni, String nombre, String email, String telefono,
                           Localidad localidad, double limiteMensual) throws ClienteException {
        super(dni, nombre, email, telefono, localidad);

        if (limiteMensual <= 0) {
            throw new ClienteException("El límite mensual debe ser mayor a cero");
        }

        this.limiteMensual = limiteMensual;
        this.gastosMesActual = 0.0;
    }

    @Override
    public void agregarCompra(Compra compra) throws ClienteException {
        if (compra.getImporte() <= 0) {
            throw new ClienteException("El importe debe ser mayor que cero");
        }

        if (gastosMesActual + compra.getImporte() > limiteMensual) {
            throw new ClienteException("La compra supera el límite mensual disponible");
        }

        compras.add(compra);
        gastosMesActual += compra.getImporte();
    }

    public double getLimiteMensual() {
        return limiteMensual;
    }

    public double getGastosMesActual() {
        return gastosMesActual;
    }

    public double getLimiteDisponible() {
        return limiteMensual - gastosMesActual;
    }

    public void reiniciarLimiteMensual() {
        this.gastosMesActual = 0.0;
    }
}