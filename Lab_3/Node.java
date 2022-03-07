package com.company;

import java.util.ArrayList;

public abstract class Node {
    String nodeName;
    String hardwareAddress;
    String mapLocation;

    public Node(String nodeName) {
        this.nodeName = nodeName;
        this.hardwareAddress = "Unknown";
        this.mapLocation = "Unknown";
    }

    public Node(String nodeName, String hardwareAddress) {
        this.nodeName = nodeName;
        this.hardwareAddress = hardwareAddress;
        this.mapLocation = "Unknown";
    }

    public Node(String nodeName, String hardwareAddress, String mapLocation) {
        this.nodeName = nodeName;
        this.hardwareAddress = hardwareAddress;
        this.mapLocation = mapLocation;
    }

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

    @Override
    public String toString() {
        return "Node{" +
                "nodeName='" + nodeName + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", mapLocation='" + mapLocation + '\'' +
                "}\n";
    }
}
