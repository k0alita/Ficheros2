package Boletin1.Ejercicio9;

import Boletin1.Ejercicio5.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio9 {
    public static void main(String[] args) {
        String nombreFichero = MiEntradaSalida.leerLinea("Introduce el nombre del fichero: ");

        Path path = Path.of("src", "Boletin1", "Ejercicio9", nombreFichero);
        Path pathSalida = Path.of("src", "Boletin1", "Ejercicio9", "MatriculasCorrectas.txt");

        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            System.out.println("El fichero no existe o no es valido");
            return;
        }

        String regex = "\\p{L}+\\s\\d{4}-[B-Z&&[^EIOU]]{3}";

        try (Stream<String> lineas = Files.lines(path)) {
        lineas.filter(m -> m.matches(regex)).forEach(m -> {
            try {
                Files.write(pathSalida, List.of(m),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

            System.out.println("Proceso completado. Revisa MatriculasCorrectas.txt");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
