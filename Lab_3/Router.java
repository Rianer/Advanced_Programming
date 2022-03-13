package com.company;

public class Router extends Node implements Identifiable {//describes a Node of type Router
    String ipAddress;

    //Constructors
    public Router(String nodeName) {
        super(nodeName);
        this.ipAddress = "Unknown";
    }

    public Router(String nodeName, String mapLocation) {
        super(nodeName, mapLocation);
        this.ipAddress = "Unknown";
    }

    public Router(String nodeName, String mapLocation, String hardwareAddress) {
        super(nodeName, mapLocation, hardwareAddress);
        this.ipAddress = "Unknown";
    }

    //Overrides for interface Identifiable
    @Override
    public String getIp() {
        return ipAddress;
    }

    @Override
    public void setIp(String ip) {
        this.ipAddress = ip;
    }

    @Override
    public String toString() {
        return "\nRouter{" +
                "nodeName='" + nodeName + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", mapLocation='" + mapLocation + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
