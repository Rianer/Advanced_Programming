package com.company;

public class Switch extends Node implements Identifiable{//describes a Node of type Switch
    String ipAddress;
    //Constructor
    public Switch(String nodeName) {
        super(nodeName);
    }

    public Switch(String nodeName, String hardwareAddress) {
        super(nodeName, hardwareAddress);
    }

    public Switch(String nodeName, String hardwareAddress, String mapLocation) {
        super(nodeName, hardwareAddress, mapLocation);
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
}
