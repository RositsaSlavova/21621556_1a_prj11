package bg.tu_varna.sit.f21621556;

import java.awt.*;
import java.io.File;
import java.io.IOException;
public class CommandLineInterface {
    private File file;

    public CommandLineInterface() {
    }

    public void open(String fileName) throws IOException {
        file=new File(fileName);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                System.out.println("There is a problem. The file is not created: "+e.getMessage());
            }
        }
        try {
            Desktop.getDesktop().open(file);
            System.out.println("Successfully opened "+fileName);
        } catch (IOException e) {
            System.out.println("There is a problem. The file is not opened: " + e.getMessage());
        }
    }

    public void close() {
        // code to close the file
    }

    public void save() {
        // code to save the file
    }

    public void saveAs(String file) {
        // code to save the file with a new filename
    }

    public void help() {
        // code to display the help information
    }

    public void exit() {
        // code to exit the program
    }
}
