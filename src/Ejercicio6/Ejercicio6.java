package Ejercicio6;

import Boletin1.Ejercicio5.MiEntradaSalida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        String nombreDirectorio = MiEntradaSalida.leerLinea("Nombre: ");

        Path p = Path.of("src", "Boletin1", nombreDirectorio);

        if (Files.exists(p)) {
            if (Files.isDirectory(p)) {
                try {
                    Files.list(p).forEach(path -> {
                        if (Files.isDirectory(path)) {
                            System.out.printf("%s - directorio %n", path.getFileName());
                        } else {
                            try {
                                System.out.printf("%s - %.2f kb %n", path.getFileName(), Files.size(path)/1024.0);
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    });
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {

            }
        } else {
            System.out.println("No existe la ruta indicada");
        }

    }
}
