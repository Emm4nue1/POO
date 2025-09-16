package ar.edu.unju.fi.POO2025.Tp5.models;
import ar.edu.unju.fi.POO2025.Tp5.models.client.CuentaCorriente;
import ar.edu.unju.fi.POO2025.Tp5.models.client.GrandesCompras;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ManagerClienteTest {
    private ManagerCliente gestionClientes;
    private Localidad localidad;

    @BeforeEach
    void setUp() {
        gestionClientes = new ManagerCliente();
        localidad = new Localidad("LOC1", "San Salvador de Jujuy", "4600");
    }

    @Test
    void testRegistrarClienteCuentaCorriente() throws ClienteException {
        CuentaCorriente cliente = new CuentaCorriente(
                "12345678", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        gestionClientes.registrarCliente(cliente);

        assertEquals(1, gestionClientes.getClientes().size());
        assertEquals("12345678", gestionClientes.getClientes().get(0).getDni());
    }

    @Test
    void testRegistrarClienteGrandesCompras() throws ClienteException {
        GrandesCompras cliente = new GrandesCompras(
                "87654321", "Maria Lopez", "maria@email.com", "3885765432",
                localidad, 0.1
        );

        gestionClientes.registrarCliente(cliente);

        assertEquals(1, gestionClientes.getClientes().size());
        assertEquals("87654321", gestionClientes.getClientes().get(0).getDni());
    }

    @Test
    void testRegistrarClienteConDniDuplicado() throws ClienteException {
        CuentaCorriente cliente1 = new CuentaCorriente(
                "12345678", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        CuentaCorriente cliente2 = new CuentaCorriente(
                "12345678", "Otro Nombre", "otro@email.com", "3885111111",
                localidad, 5000.0
        );

        gestionClientes.registrarCliente(cliente1);

        assertThrows(ClienteException.class, () -> {
            gestionClientes.registrarCliente(cliente2);
        });
    }

    @Test
    void testRegistrarClienteConEmailDuplicado() throws ClienteException {
        CuentaCorriente cliente1 = new CuentaCorriente(
                "11111111", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        CuentaCorriente cliente2 = new CuentaCorriente(
                "22222222", "Maria Lopez", "juan@email.com", "3885765432",
                localidad, 5000.0
        );

        gestionClientes.registrarCliente(cliente1);

        assertThrows(ClienteException.class, () -> {
            gestionClientes.registrarCliente(cliente2);
        });
    }

    @Test
    void testRegistrarCompraCuentaCorriente() throws ClienteException {
        CuentaCorriente cliente = new CuentaCorriente(
                "12345678", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        gestionClientes.registrarCliente(cliente);

        Compra compra = new Compra("COMP1", LocalDate.now(), 5000.0);
        gestionClientes.registrarCompra("12345678", compra);

        assertEquals(1, gestionClientes.cantidadComprasCliente("12345678"));
        assertEquals(5000.0, cliente.getTotalGastado());
    }

    @Test
    void testRegistrarCompraSuperaLimite() throws ClienteException {
        CuentaCorriente cliente = new CuentaCorriente(
                "12345678", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        gestionClientes.registrarCliente(cliente);

        Compra compra1 = new Compra("COMP1", LocalDate.now(), 6000.0);
        gestionClientes.registrarCompra("12345678", compra1);

        Compra compra2 = new Compra("COMP2", LocalDate.now(), 5000.0);

        assertThrows(ClienteException.class, () -> {
            gestionClientes.registrarCompra("12345678", compra2);
        });
    }

    @Test
    void testRegistrarCompraImporteInvalido() throws ClienteException {
        CuentaCorriente cliente = new CuentaCorriente(
                "12345678", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        gestionClientes.registrarCliente(cliente);

        Compra compra = new Compra("COMP1", LocalDate.now(), -100.0);

        assertThrows(ClienteException.class, () -> {
            gestionClientes.registrarCompra("12345678", compra);
        });
    }

    @Test
    void testCantidadComprasCliente() throws ClienteException {
        CuentaCorriente cliente = new CuentaCorriente(
                "12345678", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        gestionClientes.registrarCliente(cliente);

        Compra compra1 = new Compra("COMP1", LocalDate.now(), 2000.0);
        Compra compra2 = new Compra("COMP2", LocalDate.now(), 3000.0);

        gestionClientes.registrarCompra("12345678", compra1);
        gestionClientes.registrarCompra("12345678", compra2);

        assertEquals(2, gestionClientes.cantidadComprasCliente("12345678"));
    }

    @Test
    void testTotalRecaudadoLocalidad() throws ClienteException {
        Localidad otraLocalidad = new Localidad("LOC2", "Palpalá", "4612");

        CuentaCorriente cliente1 = new CuentaCorriente(
                "11111111", "Juan Perez", "juan@email.com", "3885123456",
                localidad, 10000.0
        );

        GrandesCompras cliente2 = new GrandesCompras(
                "22222222", "Maria Lopez", "maria@email.com", "3885765432",
                localidad, 0.1
        );

        GrandesCompras cliente3 = new GrandesCompras(
                "33333333", "Carlos Gomez", "carlos@email.com", "3885999999",
                otraLocalidad, 0.15
        );

        gestionClientes.registrarCliente(cliente1);
        gestionClientes.registrarCliente(cliente2);
        gestionClientes.registrarCliente(cliente3);

        Compra compra1 = new Compra("COMP1", LocalDate.now(), 2000.0);
        Compra compra2 = new Compra("COMP2", LocalDate.now(), 3000.0);
        Compra compra3 = new Compra("COMP3", LocalDate.now(), 4000.0);

        gestionClientes.registrarCompra("11111111", compra1);
        gestionClientes.registrarCompra("22222222", compra2);
        gestionClientes.registrarCompra("33333333", compra3);

        assertEquals(5000.0, gestionClientes.totalRecaudadoLocalidad("LOC1"));
        assertEquals(4000.0, gestionClientes.totalRecaudadoLocalidad("LOC2"));
    }

    @Test
    void testClienteNoEncontrado() {
        assertThrows(ClienteException.class, () -> {
            gestionClientes.cantidadComprasCliente("99999999");
        });
    }
}