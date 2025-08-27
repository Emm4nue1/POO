package ar.edu.unju.fi.POO2025.Tp2.punto2;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;
import com.ibm.icu.text.RuleBasedNumberFormat;

public class Main {
    static Map<Integer, String> lista = new HashMap<>();
    static RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(
            Locale.forLanguageTag("es"), RuleBasedNumberFormat.SPELLOUT);

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números a generar: ");
        cargarMap(leer.nextInt());
        //mostrarCollection();
        buscarYConvertir(leer);
        mostrarCollection();
        leer.close();
    }

    public static void cargarMap(int N) {
        Random random = new Random();
        while (lista.size() < N) {
            int num = random.nextInt(101);
            if (!lista.containsKey(num)) {
                lista.put(num, formatter.format(num));
            }
        }
    }

    public static void buscarYConvertir(Scanner leer) {
        System.out.print("Ingrese clave a buscar: ");
        int clave = leer.nextInt();

        if (lista.containsKey(clave)) {
            lista.compute(clave, (k, valor) -> valor.toUpperCase());
        } else {
            System.out.println("Clave no encontrada.");
        }
    }

    public static void mostrarCollection() {
        System.out.println("\nHashMap (" + lista.size() + " elementos):");
        lista.forEach((k, v) -> System.out.println(k + " → \"" + v + "\""));
    }
}