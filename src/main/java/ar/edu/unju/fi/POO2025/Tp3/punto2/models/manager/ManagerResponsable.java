package ar.edu.unju.fi.POO2025.Tp3.punto2.models.manager;
import ar.edu.unju.fi.POO2025.Tp3.punto2.models.Responsable;
import java.util.HashMap;
import java.util.Map;

public class ManagerResponsable {
    private Map<String, Responsable> responsables;

    public ManagerResponsable() {
        responsables = new HashMap<>();
        inicializarResponsables();
    }

    private void inicializarResponsables() {
        agregarResponsable("12345678", "Juan Perez");
        agregarResponsable("23456789", "Maria Gonzalez");
        agregarResponsable("34567890", "Carlos Rodriguez");
        agregarResponsable("45678901", "Ana Martinez");
        agregarResponsable("56789012", "Luis Fernandez");
    }

    public void agregarResponsable(String documento, String nombre) {
        responsables.put(documento, new Responsable(documento, nombre));
    }

    public Responsable buscarResponsable(String documento) {
        return responsables.get(documento);
    }
}