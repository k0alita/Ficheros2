package Boletin1.Ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Path ruta = Path.of("./src/Boletin1/Ejercicio4/salidaEj4.txt");

        try (var bw = Files.newBufferedWriter(
                ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            String linea;
            System.out.println("Escribe líneas de texto. Escribe 'fin' para terminar:");

            while (true) {
                linea = teclado.nextLine();

                if (linea.equals("fin")) {
                    break;
                }

                bw.write(linea);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }

        teclado.close();
    }
}


