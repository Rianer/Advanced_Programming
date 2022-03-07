package com.company;

import java.util.Objects;

enum RoomType { //room types available
    LECTURE_HALL, COMPUTER_LAB, OTHER;

    @java.lang.Override
    public java.lang.String toString() { //used for printing the room type
        return switch (this) {
            case LECTURE_HALL -> "Lecture Hall";
            case COMPUTER_LAB -> "Computer Lab";
            case OTHER -> "Other";
            default -> null;
        };
    }
}

public class Room { //class which defines a Room
    RoomType roomType; //room's type
    String roomName; //room's name, if not specified it is set to "Unknown"
    int cap; //room's student limit

    public Room(RoomType roomType, int cap) { //constructor without specifying the name
        this.roomType = roomType;
        this.cap = cap;
        this.roomName = "Unknown";
    }

    public Room(RoomType roomType, int cap, String name) { //constructor with the name specified
        this.roomType = roomType;
        this.cap = cap;
        this.roomName = name;
    }

    //Getters and Setters for all the components
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() { //used for printing Room's properties
        return "Room{" +
                "roomType=" + roomType +
                ", roomName='" + roomName + '\'' +
                ", cap=" + cap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return cap == room.cap && roomType == room.roomType && roomName.equals(room.roomName);
    }
}
