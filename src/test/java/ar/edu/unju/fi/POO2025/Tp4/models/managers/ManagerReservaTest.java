package ar.edu.unju.fi.POO2025.Tp4.models.managers;
import ar.edu.unju.fi.POO2025.Tp4.models.Pasajero;
import ar.edu.unju.fi.POO2025.Tp4.models.Reserva;
import org.junit.jupiter.api.*;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class ManagerReservaTest {

    private ManagerReserva manager;
    private Pasajero pasajeroPrincipal;
    private Pasajero pasajeroSecundario;

    @BeforeAll
    static void initAll() {
        System.out.println("Iniciando pruebas de ManagerReserva...");
    }

    @BeforeEach
    void init() {
        manager = new ManagerReserva();
        pasajeroPrincipal = new Pasajero("Juan", "Perez", 123, "juan@test.com", "Pass1234");
        pasajeroSecundario = new Pasajero("Maria", "Lopez", 456, "maria@test.com");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test de ManagerReserva finalizado");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("--- Todos los tests de ManagerReserva finalizados ---");
    }

    @Test
    void testCrearReserva() {
        boolean creada = manager.crearReserva(1, "Jujuy", "Buenos Aires", new Date(), new Date(),
                Reserva.ClaseVuelo.ECONOMY, pasajeroPrincipal);
        assertTrue(creada);
        assertNotNull(manager.buscarPorId(1));
    }

    @Test
    void testCrearReservaConSecundario() {
        boolean creada = manager.crearReservaConSecundario(2, "Jujuy", "Salta", new Date(), new Date(),
                Reserva.ClaseVuelo.BUSINESS, pasajeroPrincipal, pasajeroSecundario);

        assertTrue(creada, "La reserva con pasajero secundario debería crearse");
        Reserva reserva = manager.buscarPorId(2);
        assertNotNull(reserva, "La reserva debe existir");
        assertEquals(pasajeroSecundario, reserva.getPasajero().getPasajeroSecundario(),
                "El pasajero principal debe tener asignado al secundario");
    }

    @Test
    void testCancelarReserva() {
        manager.crearReserva(3, "Jujuy", "Cordoba", new Date(), new Date(),
                Reserva.ClaseVuelo.BUSINESS, pasajeroPrincipal);
        assertTrue(manager.cancelar(3));
        assertEquals(Reserva.EstadoReserva.CANCELADA, manager.buscarPorId(3).getEstado());
    }

    @Test
    void testFiltrarPorClase() {
        manager.crearReserva(4, "Jujuy", "Salta", new Date(), new Date(),
                Reserva.ClaseVuelo.ECONOMY, pasajeroPrincipal);
        assertEquals(1, manager.filtrarPorClase(Reserva.ClaseVuelo.ECONOMY).size());
    }
}
