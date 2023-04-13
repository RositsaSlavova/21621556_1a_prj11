package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OpenCommand implements Command {
    private ArrayList<String> fileContents;

    public OpenCommand() {
        fileContents = new ArrayList<>();
    }
    @Override
    public void execute(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + fileName);
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;
            }
        }
        else
        {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    fileContents.add(line);
                }
                System.out.println("Successfully opened "+fileName);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
    public ArrayList<String> getFileContents() {
        return fileContents;
    }
}
//Чете от посочения файл и записва информацията в списък, ако няма такъв файл, то той се създава, после ако искаме да прочетем от този файл
//пак с open и вече се отваря и чете от информацията
