package ar.edu.unju.fi.POO2025.Tp4.models.managers;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ManagerPasajeroTest {

    private ManagerPasajero manager;

    @BeforeAll
    static void initAll() {
        System.out.println("Iniciando pruebas de ManagerPasajero...");
    }

    @BeforeEach
    void init() {
        manager = new ManagerPasajero();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test de ManagerPasajero finalizado");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("--- Todos los tests de ManagerPasajero finalizados ---");
    }

    @Test
    void testAgregarPasajeroValido() {
        boolean agregado = manager.agregarPasajero("Juan", "Perez", 123, "juan@test.com", "Pass1234");
        assertTrue(agregado);
        assertNotNull(manager.buscarPorDNI(123));
    }

    @Test
    void testAgregarPasajeroConPasswordInvalida() {
        boolean agregado = manager.agregarPasajero("Ana", "Lopez", 456, "ana@test.com", "clave"); // corta y sin números
        assertFalse(agregado);
        assertNull(manager.buscarPorDNI(456));
    }

    @Test
    void testAgregarPasajeroSecundario() {
        boolean agregado = manager.agregarPasajeroSecundario("Luis", "Gomez", 789, "luis@test.com");
        assertTrue(agregado);
        assertNotNull(manager.buscarPorDNI(789));
    }

    @Test
    void testEliminarPasajero() {
        manager.agregarPasajero("Sofia", "Martinez", 111, "sofia@test.com", "Clave1234");
        assertTrue(manager.eliminar(111));
        assertNull(manager.buscarPorDNI(111));
    }
}
