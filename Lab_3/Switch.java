package com.company;

public class Switch extends Node implements Identifiable{
    String ipAddress;
    public Switch(String nodeName) {
        super(nodeName);
    }

    public Switch(String nodeName, String hardwareAddress) {
        super(nodeName, hardwareAddress);
    }

    public Switch(String nodeName, String hardwareAddress, String mapLocation) {
        super(nodeName, hardwareAddress, mapLocation);
    }

    public String getIp() {
        return ipAddress;
    }

    public void setIp(String ip) {
        this.ipAddress = ip;
    }
}
