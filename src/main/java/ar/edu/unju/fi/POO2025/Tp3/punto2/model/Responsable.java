package ar.edu.unju.fi.POO2025.Tp3.punto2.model;

public class Responsable {
    private String documento;
    private String nombre;

    public Responsable(String documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}

