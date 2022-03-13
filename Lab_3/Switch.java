package com.company;

public class Switch extends Node {//describes a Node of type Switch

    //Constructor

    public Switch(String nodeName) {
        super(nodeName);
    }

    public Switch(String nodeName, String mapLocation) {
        super(nodeName, mapLocation);
    }

    public Switch(String nodeName, String mapLocation, String hardwareAddress) {
        super(nodeName, mapLocation, hardwareAddress);
    }

    @Override
    public String toString() {
        return "\nSwitch{" +
                "nodeName='" + nodeName + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", mapLocation='" + mapLocation + '\'' +
                '}';
    }
}
