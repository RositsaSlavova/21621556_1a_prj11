package bg.tu_varna.sit.f21621556.commands;

import bg.tu_varna.sit.f21621556.contracts.CommandHotel;
import bg.tu_varna.sit.f21621556.entities.Hotel;
import bg.tu_varna.sit.f21621556.entities.Room;

import java.util.List;

public class CheckInCommand implements CommandHotel {
    //private Hotel hotel;
    private List<String> roomList;
    private String roomNumber;
    private String fromDate;
    private String toDate;
    private String note;
    private int guestNumber;

    @Override
    public void execute(List<String> roomList, String[] command, Hotel hotel) {
        if (roomList.isEmpty()) {
            System.out.println("Please open a file and add some content first.");
            return;
        }
        if(command.length<5){
            System.out.println("You have to write: checkin <room> <from> <to> <note> [<guests>]");
            return;
        }
        this.roomList=roomList;
        roomNumber=command[1];
        fromDate=command[2];
        toDate=command[3];
        note=command[4];

        if (isRoomCheckedIn()) {
            System.out.println("The room is already checked in for the specified dates");
            return;
        }

        Room room = hotel.getRoomByNumber(roomNumber);
        if (room == null) {
            System.out.println("Invalid room number");
            return;
        }

        if(command.length > 5) guestNumber = Integer.parseInt(command[5]);
        else guestNumber = room.getBedsNumber();

        StringBuilder entryBuilder = new StringBuilder();
        entryBuilder.append(roomNumber).append(" ");
        entryBuilder.append(fromDate).append(" ");
        entryBuilder.append(toDate).append(" ");
        entryBuilder.append(note).append(" ");
        entryBuilder.append(guestNumber);

        String entry = entryBuilder.toString();
        roomList.add(entry);
        System.out.println("Check-in successful");
    }

    private boolean isRoomCheckedIn(){
        for (String line: roomList) {
            String[] parts=line.split(" ");
            String entryRoomNumber=parts[0];
            if(entryRoomNumber.equals(roomNumber)){
                String entryFromDate=parts[1];
                String entryToDate=parts[2];
                if (entryFromDate.equals(fromDate) || entryFromDate.equals(toDate) || entryToDate.equals(fromDate) || entryToDate.equals(toDate)) {
                    return true;
                }
            }
        }
        return false;
    }
}

