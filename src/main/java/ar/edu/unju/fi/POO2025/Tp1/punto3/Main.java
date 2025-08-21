package ar.edu.unju.fi.POO2025.Tp1.punto3;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        int cont = 0;
        System.out.println("Los próximos 10 años bisiestos son:");
        for (int i = Year.now().getValue() + 1; cont < 10; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                System.out.println(++cont + ". " + i);
            }
        }
    }
}