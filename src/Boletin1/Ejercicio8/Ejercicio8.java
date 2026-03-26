package Boletin1.Ejercicio8;

import Boletin1.Ejercicio5.MiEntradaSalida;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Stream;

public class Ejercicio8 {
    static void main(String[] args) {
        String nombreFichero = MiEntradaSalida.leerLinea("Introduce el nombre del fichero: ");

        Path path = Path.of("src", "Boletin1", nombreFichero);

        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            System.out.println("El fichero no existe o no es valido");
            return;
        }
        try (Stream<String> lineas = Files.lines(path)){

            boolean cumple = lineas.allMatch(l -> l.matches("(\\p{L}{2,}\\s){3}([1-9]|([1-9][0-9]))$"));
            if (cumple) {
                System.out.println("Cumple");
            } else {
                System.out.println("No cumple");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
