package Boletin1.Ejercicio10;

import Boletin1.Ejercicio5.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio10 {
    public static void main(String[] args) {
        leerFichero();
    }

        public static void leerFichero() {
            String nombreFichero = MiEntradaSalida.leerLinea("Indica el nombre del fichero: \n");
            Path fichero = Path.of("src", "Boletin1", "Ejercicio10", nombreFichero);

            if (Files.isRegularFile(fichero) && Files.isReadable(fichero)) {
                Pattern p = Pattern.compile("^F\\s((?:\\w:\\/)?(?:\\w+\\/)*[\\d\\p{L}]{3,}\\.\\p{L}{3})$");

                try (Stream<String> lineas = Files.lines(fichero)){
                    lineas.map(p::matcher).filter(Matcher::find)
                            .map(m -> m.group(1)).map(Path::of)
                            .forEach(s -> {
                                try {
                                    Files.createFile(s);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            });
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("no encontrado");
            }
        }
}
