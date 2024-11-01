package org.example.controller;

import org.example.Main;
import org.example.TeltonikaParser;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teltonika")
public class TeltonikaController {

    @GetMapping("/parse")
    public List<Map<String, Object>> parseTeltonikaData() {

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("data.txt");

        if (inputStream == null) {
            System.out.println("Fajl data.txt nije pronađen u resources folderu.");
            return Collections.emptyList();
        }

        List<Map<String, Object>> dtoList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String hexData;
            while ((hexData = reader.readLine()) != null) {
                System.out.println("Parsiram hex data: " + hexData);
                Map<String, Object> parsedData = TeltonikaParser.parseTeltonikaData(hexData);

                 dtoList.add(parsedData);
            }
        } catch (IOException e) {
            System.err.println("Greška prilikom čitanja data.txt: " + e.getMessage());
        }

        return dtoList;
    }

}
