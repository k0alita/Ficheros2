package Boletin1.Ejercicio3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio3New {
    public static void main(String[] args) {
        Path salida = Path.of("./src/Boletin1/Ejercicio3/salidaEj3.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String linea;
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")){
                Files.writeString(salida, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}