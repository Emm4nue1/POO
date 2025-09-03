package ar.edu.unju.fi.POO2025.Tp3.punto2.models.cars;
import ar.edu.unju.fi.POO2025.Tp3.punto2.models.Responsable;

public abstract class Vehiculo {
    protected String matricula;
    protected boolean alquilado;
    protected Responsable responsable;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.alquilado = false;
    }

    public void alquilar(Responsable responsable) {
        this.responsable = responsable;
        this.alquilado = true;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public abstract double devolver();
    public abstract double calcularImporte();

}
