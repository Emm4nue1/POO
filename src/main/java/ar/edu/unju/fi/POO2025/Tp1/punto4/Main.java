package ar.edu.unju.fi.POO2025.Tp1.punto4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = leer.next();
        String palabraInvertida = new StringBuilder(palabra).reverse().toString();
        if (palabra.equals(palabraInvertida)) {
            System.out.println("La palabra '" + palabra + "' es un palíndromo");
        } else {
            System.out.println("La palabra '" + palabra + "' NO es un palíndromo");
        }
        leer.close();
    }
}