package com.company;

import java.util.ArrayList;

public class Computer extends Node implements Storage, Identifiable { //describes a Node of type Computer
    String ipAddress = "-";
    double storage;
    //Constructors

    public Computer(String nodeName) {
        super(nodeName);
        this.ipAddress = "Unknown";
    }

    public Computer(String nodeName, String mapLocation) {
        super(nodeName, mapLocation);
        this.ipAddress = "Unknown";
    }

    public Computer(String nodeName, String mapLocation, String hardwareAddress) {
        super(nodeName, mapLocation, hardwareAddress);
        this.ipAddress = "Unknown";
    }

    //Overrides from interface Storage

    @Override
    public void setStorage(double size) {
        this.storage = size;
    }

    @Override
    public double getStorage() {
        return this.storage;
    }

    @Override
    public String getIp() {
        return ipAddress;
    }

    @Override
    public void setIp(String ip) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "\nComputer{" +
                "nodeName='" + nodeName + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", mapLocation='" + mapLocation + '\'' +
                ", storage=" + storage +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
