package ar.edu.unju.fi.POO2025.Tp1.punto1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese su altura en metros: ");
        double altura = leer.nextDouble();
        System.out.print("Ingrese su peso corporal en kg: ");
        int peso = leer.nextInt();
        double imc = peso / (altura*altura);
        System.out.print("Su IMC (Índice de masa corporal) es: " + imc);
        leer.close();
    }
}