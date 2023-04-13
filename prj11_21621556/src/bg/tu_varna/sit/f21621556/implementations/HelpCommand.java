package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

public class HelpCommand implements Command {
    @Override
    public void execute(String fileName) {
        System.out.println("The following commands are supported:");
        System.out.println("open <file>\t      opens <file>");
        System.out.println("close\t          closes currently opened file");
        System.out.println("save\t          saves the currently open file");
        System.out.println("saveAs <file>\t  saves the currently open file in <file>");
        System.out.println("help\t          prints this information");
        System.out.println("exit\t          exists the program");
    }
}
//Извежда кратка информация за поддържаните от програмата команди