package ar.edu.unju.fi.POO2025.Tp1.Tp2.punto1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Escribir una palabra: ");
        String palabra = leer.nextLine().toLowerCase();
        int cont = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                cont++;
            }
        }
        for (int i = 1; i <= palabra.length(); i++) {
            System.out.println(palabra.substring(0, i));
        }
        System.out.println("Vocales: " + cont);
        leer.close();
    }
}