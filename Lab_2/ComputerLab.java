package com.company;

public class ComputerLab extends Room {//describes a Room of type ComputerLab
    String operatingSystemName;
    //Constructors
    public ComputerLab(String roomName, int cap) {
        super(roomName, cap);
        this.operatingSystemName = "Unknown";
    }

    public ComputerLab(String roomName, int cap, String operatingSystemName) {
        super(roomName, cap);
        this.operatingSystemName = operatingSystemName;
    }

    @Override
    public String toString() {
        return "ComputerLab{" +
                "operatingSystemName='" + operatingSystemName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", cap=" + cap +
                '}';
    }
}
