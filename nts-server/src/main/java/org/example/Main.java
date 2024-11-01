package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Učitavanje fajla data.txt iz resources foldera
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("data.txt");

        if (inputStream == null) {
            System.out.println("Fajl data.txt nije pronađen u resources folderu.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String hexData;
            while ((hexData = reader.readLine()) != null) {
                System.out.println("Parsiram hex data: " + hexData);
                Map<String, Object> parsedData = TeltonikaParser.parseTeltonikaData(hexData);
                System.out.println(parsedData);
            }
        } catch (IOException e) {
            System.err.println("Greška prilikom čitanja data.txt: " + e.getMessage());
        }
    }
}
