package ar.edu.unju.fi.POO2025.Tp1.punto2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double tna = 33.0; // Usar double para evitar división entera
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el capital (mayor a $1000): $");
        double capital = leer.nextDouble();
        if (capital <= 1000) {
            System.out.println("Error: El capital debe ser mayor a $1000");
            leer.close();
            return;
        }
        System.out.print("Ingrese el plazo en días (mayor a 30 días): ");
        int plazo = leer.nextInt();
        if (plazo <= 30) {
            System.out.println("Error: El plazo debe ser mayor a 30 días");
            leer.close();
            return;
        }
        double rentabilidad = capital * (tna / 100 * plazo / 365);
        System.out.println("Capital: $" + capital);
        System.out.println("Plazo: " + plazo + " días");
        System.out.println("TNA: " + tna + "%");
        System.out.println("Rentabilidad: $" + rentabilidad);
        leer.close();
    }
}