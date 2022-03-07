package com.company;

import java.util.Objects;

abstract public class Room { //class which defines a Room
    String roomName;
    int cap;

    public Room(String roomName, int cap) {
        this.roomName = roomName;
        this.cap = cap;
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
                "roomType=" + this.getClass() +
                ", roomName='" + roomName + '\'' +
                ", cap=" + cap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return cap == room.cap && roomName.equals(room.roomName);
    }
}
