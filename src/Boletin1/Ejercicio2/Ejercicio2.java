package Boletin1.Ejercicio2;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("./src/Boletin1/Ejercicio2/leeme.txt");

        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.print(linea + " ");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }


    }
}
