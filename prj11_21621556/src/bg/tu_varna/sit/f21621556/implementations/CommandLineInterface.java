package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

import java.util.*;

public class CommandLineInterface {
    protected static Map<String, Command> commands;
    private String currentFile;
    private List<String>fileContents = new ArrayList<>();

    public CommandLineInterface() {
        commands=new HashMap<>();
        commands.put("open",new OpenCommand());
        commands.put("close",new CloseCommand());
        commands.put("save",new SaveCommand());
        commands.put("saveas",new SaveAsCommand());
        commands.put("help",new HelpCommand());
        commands.put("exit",new ExitCommand());
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
                    currentFile = fileName;
                    System.out.println("Сегашният файл е "+currentFile);

                    //Съдържанието какво е от прочетения файл
                    System.out.println("File contents: ");
                    fileContents = ((OpenCommand) commands.get("open")).getFileContents();
                    System.out.println(fileContents);
                }
                break;
                case "close":
                {
                    commands.get("close").execute(currentFile);
                    if(currentFile!=null)
                    {
                        currentFile=null;
                        fileContents.clear();
                    }
                }
                break;
                case "save":
                {
                    if (currentFile == null) {
                        System.out.println("No file is currently open");
                        continue;
                    }
                    commands.get("save").execute(currentFile);
                }
                break;
                case "saveas":
                {
                    if (commandArguments.length < 2) {
                        System.out.println("You have to write: saveas <file>");
                        continue;
                    }
                    String fileName = commandArguments[1];
                    commands.get("saveas").execute(fileName);
                }
                break;

                case "help":
                {
                    commands.get("help").execute(null);
                    /*Не съм я направила да се изпълнява, само когато вече сме дали open на файл, защото помощ може
                    * да е нужна по всяко време*/
                }
                break;
                case "exit":
                {
                    commands.get("exit").execute(null);
                }
                break;
            }
        }
    }
}