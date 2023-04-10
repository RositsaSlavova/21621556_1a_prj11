package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLineInterface {
    private Map<String, Command> commands;
    private String currentFile;

    public CommandLineInterface() {
        commands=new HashMap<>();
        commands.put("open",new OpenCommand(""));
        //commands.put("close",new CloseCommand(""));
    }

    public void run(){
        Scanner scanner=new Scanner(System.in);
        String input;
        while(true){
            System.out.print(">");
            input=scanner.nextLine();
            String[] commandArguments=input.split(" ");
            String commandName=commandArguments[0];

            switch (commandName){
                case "open":
                {
                    if(commandArguments.length < 2) {
                        System.out.println("You have to write: open <file>");
                        continue;
                    }
                    String fileName=commandArguments[1];
                    commands.get("open").execute(fileName);
                    currentFile = ((OpenCommand) commands.get("open")).getFileName();
                }break;
                /*case "close":
                {
                    commands.get("close").execute(currentFile);
                    currentFile = ((CloseCommand) commands.get("close")).getFileName();
                }break;*/
            }
        }
    }
}