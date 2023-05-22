package bg.tu_varna.sit.f21621556.contracts;

import bg.tu_varna.sit.f21621556.entities.Hotel;
import bg.tu_varna.sit.f21621556.entities.Room;

import java.util.List;

public interface CommandHotel {
    void execute(List<String> roomList,String[] command, Hotel hotel);
}
