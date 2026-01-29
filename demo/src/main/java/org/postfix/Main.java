package org.postfix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the PostfixCalculator
        Calc calculadora = new PostfixCalculator();
        
        // Name of the input file
        String nombreArchivo = "src/main/resources/datos.txt";
        
        try {
            // open the file for reading
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader lector = new BufferedReader(archivo);
            
            System.out.println("=== CALCULADORA POSTFIX ===\n");
            
            String linea;
            int numeroLinea = 1;
            
            // Read each line from the file
            while ((linea = lector.readLine()) != null) {
                
                // Ignore empty lines
                if (linea.trim().isEmpty()) {
                    continue;
                }
                
                // Display the expression
                System.out.println("Expresion " + numeroLinea + ": " + linea);
                
                try {
                    // Calculate the result
                    double resultado = calculadora.calculate(linea);
                    System.out.println("Resultado: " + resultado);
                    
                } catch (Exception e) {
                    // If there is an error in calculation
                    System.out.println("Error: " + e.getMessage());
                }
                
                System.out.println(); // Print a blank line for better readability
                numeroLinea++;
            }
            
            // Close the file
            lector.close();
            archivo.close();
            
        } catch (IOException e) {
            // If the file cannot be read
            System.err.println("No se pudo leer el archivo: " + nombreArchivo);
            System.err.println("Error: " + e.getMessage());
        }
    }
}