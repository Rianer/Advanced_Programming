package com.company;

import java.util.ArrayList;

public class Computer extends Node implements Storage, Identifiable{
    String ipAddress;
    ArrayList<Double> dataSizeList = new ArrayList<Double>();
    ArrayList<String> dataList = new ArrayList<String>();

    public Computer(String nodeName) {
        super(nodeName);
    }

    public Computer(String nodeName, String hardwareAddress) {
        super(nodeName, hardwareAddress);
    }

    public Computer(String nodeName, String hardwareAddress, String mapLocation) {
        super(nodeName, hardwareAddress, mapLocation);
    }
    @Override
    public void storeData(String data, double size) {
        dataList.add(data);
        dataSizeList.add(size);
    }
    @Override
    public String getData(int index) {
        return dataList.get(index);
    }
    @Override
    public double getDataSize(int index) {
        return dataSizeList.get(index);
    }
    @Override
    public String getIp() {
        return ipAddress;
    }
    @Override
    public void setIp(String ip) {
        this.ipAddress = ipAddress;
    }
}
