package org.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataLoader implements DataLoader {
    @Override
    public List<String> load(String filename) {
        List<String> persons = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                persons.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
