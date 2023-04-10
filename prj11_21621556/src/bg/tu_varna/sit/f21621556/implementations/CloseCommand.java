package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

public class CloseCommand implements Command {
    private String fileName;

    public CloseCommand(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute(String currentFile) {
        if(currentFile == null) {
            System.out.println("No file is currently open.");
            return;
        }
        System.out.println("Successfully closed " + currentFile);
        fileName = null;
    }
    public String getFileName() {
        return fileName;
    }
}
