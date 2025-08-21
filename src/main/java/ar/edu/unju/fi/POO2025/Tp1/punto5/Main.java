package ar.edu.unju.fi.POO2025.Tp1.punto5;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static int[] numeros = new int[30];

    public static void main(String[] args) {
        //Punto A
        cargarArray();
        //Punto B
        mostrarArray();
        //Punto C
        modificarPares();
        mostrarArray();
    }

    public static void cargarArray() {
        for (int i = 0; i < numeros.length; i++) {
            int num;
            do {
                num = random.nextInt(1000) + 1; // Número aleatorio 1-1000
            } while (esRepetido(num, i) || esPrimo(num));
            numeros[i] = num;
        }
        System.out.println("Array cargado con 30 números únicos no primos");
    }

    public static boolean esRepetido(int num, int hasta) {
        for (int i = 0; i < hasta; i++) {
            if (numeros[i] == num) return true;
        }
        return false;
    }

    public static boolean esPrimo(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    public static void mostrarArray() {
        System.out.println("\nNúmeros del array:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }

    public static void modificarPares() {
        System.out.println("\n\nModificando pares:");
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                int original = numeros[i];
                numeros[i] *= numeros[i]; // Eleva al cuadrado
                System.out.println(original + "² = " + numeros[i]);
                contador++;
            }
        }
        System.out.println("Se modificaron " + contador + " números pares");
    }
}
