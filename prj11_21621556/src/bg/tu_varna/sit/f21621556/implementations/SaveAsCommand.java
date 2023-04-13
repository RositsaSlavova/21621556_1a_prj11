package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveAsCommand implements Command {
    @Override
    public void execute(String fileName) {
        List<String> fileContents = ((OpenCommand) CommandLineInterface.commands.get("open")).getFileContents();
        if (!fileContents.isEmpty()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (String line : fileContents) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
                System.out.println("Successfully saved " + fileName);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Nothing to save. Please open a file and add some content first.");
        }
    }
}
