package bg.tu_varna.sit.f21621556.entities;

import java.time.LocalDate;

public class Room {
    private String number;
    private int bedsNumber;
    private boolean availability;

    public Room(String number, int bedsNumber) {
        this.number = number;
        this.bedsNumber = bedsNumber;
        this.availability=true;
    }

    public String getNumber() {
        return number;
    }

    public int getBedsNumber() {
        return bedsNumber;
    }

    public boolean isAvailability() {
        return availability;
    }
}
