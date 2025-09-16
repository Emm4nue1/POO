package ar.edu.unju.fi.POO2025.Tp5.models;

public class Localidad {
    private String id;
    private String nombre;
    private String codigoPostal;

    public Localidad(String id, String nombre, String codigoPostal) {
        this.id = id;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
}