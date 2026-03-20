package Boletin1.Ejercicio3;

import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        File salida = new File("./src/Boletin1/Ejercicio3/salidaEj3.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(new FileWriter(salida, true))) {


            String linea;
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")) {
                pw.println(linea);
                //pw.write(linea);
            }



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


