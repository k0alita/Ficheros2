package Boletin1.Ejercicio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio1 {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("./src/Boletin1/Ejercicio1/leeme.txt");

        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {

/*             --- FORMA 1 (desactivada): Lectura manual línea a línea con readLine() ---
            int numLineas = 0;
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                numLineas++;
            }
            System.out.println("Numero de lineas: " + numLineas);

        */

/*             --- FORMA 2 (desactivada): Stream API sobre BufferedReader ---
             br.lines() devuelve un Stream<String> y .count() cuenta el número de líneas
            System.out.printf("Habia %d lineas", br.lines().count());

             --- FORMA 3 (activa): Lectura con la API moderna NIO (java.nio.file) ---*/
            Path p = Path.of("./src/Boletin1/Ejercicio1/leeme.txt");

            System.out.printf("Habia %d lineas", Files.lines(p).count());

        } catch (IOException e) {
            // Captura errores de E/S: fichero no encontrado, permisos insuficientes, etc.
            System.out.println(e.getMessage());
        }
    }
}
