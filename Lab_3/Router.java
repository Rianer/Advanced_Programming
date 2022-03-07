package com.company;

public class Router extends Node implements Identifiable{
    String ipAddress;
    public Router(String nodeName) {
        super(nodeName);
    }

    public Router(String nodeName, String hardwareAddress) {
        super(nodeName, hardwareAddress);
    }

    public Router(String nodeName, String hardwareAddress, String mapLocation) {
        super(nodeName, hardwareAddress, mapLocation);
    }
    @Override
    public String getIp() {
        return ipAddress;
    }
    @Override
    public void setIp(String ip) {
        this.ipAddress = ip;
    }
}
