package bg.tu_varna.sit.f21621556.implementations;

import bg.tu_varna.sit.f21621556.contracts.Command;

import java.util.ArrayList;
import java.util.List;

public class CloseCommand implements Command {
    @Override
    public void execute(String fileName) {
        if(fileName == null) System.out.println("No file is currently open.");
        else System.out.println("Successfully closed " + fileName);
    }
}
//Проверява дали има отворен файл, ако има излиза съобщение, че е затворен и в CommandLineInterface се
//занулява променливата currentFile, за да е ясно, че не може да се извършва каквото и да е с този файл
//освен ако не се отвори пак, или искаме да отворим друг файл