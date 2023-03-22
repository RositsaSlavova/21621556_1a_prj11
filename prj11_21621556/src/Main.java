import bg.tu_varna.sit.f21621556.CommandLineInterface;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        CommandLineInterface commandLineInterface=new CommandLineInterface();
        Scanner scanner = new Scanner(System.in);
        String command, fileName;
        while(true){
            System.out.print("> ");
            command = scanner.nextLine();
            String[] commandIntoParts=command.split("\s+");
            if(commandIntoParts[0].equalsIgnoreCase("open")){
                fileName=commandIntoParts[1];
                commandLineInterface.open(fileName);
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            }
        }

    }
}