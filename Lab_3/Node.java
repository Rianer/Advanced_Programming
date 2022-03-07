package com.company;

import java.util.ArrayList;

public abstract class Node { //describes nodes in a network
    String nodeName;
    String hardwareAddress;
    String mapLocation;
    //Constructors
    public Node(String nodeName) {
        this.nodeName = nodeName;
        this.hardwareAddress = "Unknown";
        this.mapLocation = "Unknown";
    }

    public Node(String nodeName, String mapLocation) {
        this.nodeName = nodeName;
        this.hardwareAddress = "Unknown";
        this.mapLocation = mapLocation;
    }

    public Node(String nodeName, String hardwareAddress, String mapLocation) {
        this.nodeName = nodeName;
        this.hardwareAddress = hardwareAddress;
        this.mapLocation = mapLocation;
    }
    //Getters and Setters
    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getHardwareAddress() {
        return hardwareAddress;
    }

    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }
    //Converts node information intro string format
    @Override
    public String toString() {
        return "\nNode{" +
                "nodeName='" + nodeName + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", mapLocation='" + mapLocation + '\'' +
                "}";
    }
}
