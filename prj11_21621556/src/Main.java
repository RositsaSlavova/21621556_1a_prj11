import bg.tu_varna.sit.f21621556.entities.Hotel;
import bg.tu_varna.sit.f21621556.entities.Room;
import bg.tu_varna.sit.f21621556.implementations.CommandLineInterface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        Hotel hotel=new Hotel("RSS",3);

        Room room1=new Room("100",3);
        Room room2=new Room("101",5);
        Room room3=new Room("102",2);

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        CommandLineInterface commandLineInterface=new CommandLineInterface(hotel);
        commandLineInterface.run();
    }
}