package bg.tu_varna.sit.f21621556.commands;

import bg.tu_varna.sit.f21621556.contracts.CommandHotel;
import bg.tu_varna.sit.f21621556.entities.Hotel;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AvailabilityCommand implements CommandHotel {
    private List<String> roomList;

    @Override
    public void execute(List<String> roomList, String[] command, Hotel hotel) {
        if (roomList.isEmpty()) {
            System.out.println("Nothing to save. Please open a file and add some content first.");
            return;
        }
        this.roomList=roomList;

        LocalDate date = command.length > 1 ? LocalDate.parse(command[1]) : LocalDate.now();

        String availability = getAvailability(date);
        System.out.println(availability);
    }
    private String getAvailability(LocalDate date) {
        StringBuilder availability = new StringBuilder();
        availability.append("Available rooms on ").append(date).append(": ");

        Set<String> availableRooms = new LinkedHashSet<>();

        for (String room : roomList) {
            String[] parts = room.split(" ");
            String roomNumber = parts[0];
            String fromDate = parts[1];
            String toDate = parts[2];

            LocalDate from = LocalDate.parse(fromDate);
            LocalDate to = LocalDate.parse(toDate);

            if (date.isAfter(to) || date.isBefore(from)) {
                availableRooms.add(roomNumber);
            } else {
                availableRooms.remove(roomNumber); // Remove room if it becomes unavailable
            }
        }

        boolean hasAvailableRooms = false;
        for (String roomNumber : availableRooms) {
            availability.append(roomNumber).append(", ");
            hasAvailableRooms = true;
        }

        if (!hasAvailableRooms) {
            availability.append("None");
        } else {
            // Remove the trailing comma and space
            availability.setLength(availability.length() - 2);
        }

        return availability.toString();
    }
}
