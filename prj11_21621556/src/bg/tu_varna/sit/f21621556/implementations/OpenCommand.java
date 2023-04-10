package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCommand implements Command {
    private String fileName;
    private String fileContent;

    public OpenCommand(String fileName) {
        this.fileName = fileName;
        this.fileContent = "";
    }

    @Override
    public void execute(String fileName) {
        try {
            this.fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
            System.out.println("Successfully loaded " + fileName + " into memory");
            this.fileName = fileName;
        } catch (IOException e) {
            System.out.println("There is a problem. The file is not opened: " + e.getMessage());
        }
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileContent() {
        return fileContent;
    }
}
