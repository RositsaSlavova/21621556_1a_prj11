package bg.tu_varna.sit.f21621556.commands;

import bg.tu_varna.sit.f21621556.contracts.CommandHotel;
import bg.tu_varna.sit.f21621556.entities.Hotel;

import java.time.LocalDate;
import java.util.List;

public class CheckOutCommand implements CommandHotel {
    @Override
    public void execute(List<String> roomList, String[] command, Hotel hotel) {
        if (command.length < 2) {
            System.out.println("You have to write: checkout <room>");
            return;
        }

        String roomNumber = command[1];

        boolean isRoomAvailable = checkAvailabilityAndRemove(roomList, roomNumber);

        if (isRoomAvailable) {
            System.out.println("Room " + roomNumber + " has been successfully checked out.");
        } else {
            System.out.println("Room " + roomNumber + " is available.");
        }
    }
    private boolean checkAvailabilityAndRemove(List<String> roomList, String roomNumber) {
        LocalDate currentDate = LocalDate.now();
        boolean isRoomAvailable = false;

        for (String room : roomList) {
            String[] parts = room.split(" ");
            String currentRoomNumber = parts[0];
            String fromDate = parts[1];
            String toDate = parts[2];

            LocalDate from = LocalDate.parse(fromDate);
            LocalDate to = LocalDate.parse(toDate);

            if (roomNumber.equals(currentRoomNumber)) {
                if ((currentDate.equals(from) || currentDate.equals(to)) || (currentDate.isAfter(from) && currentDate.isBefore(to))) {
                    isRoomAvailable = true;
                    roomList.remove(room);
                    break;
                }
            }
        }

        return isRoomAvailable;
    }
}
