package com.company;

import java.util.ArrayList;

public class Computer extends Node implements Storage, Identifiable{ //describes a Node of type Computer
    String ipAddress;
    ArrayList<Double> dataSizeList = new ArrayList<Double>(); //list that remembers the size of the data stored
    ArrayList<String> dataList = new ArrayList<String>(); //list that stores data
    //Constructors
    public Computer(String nodeName) {
        super(nodeName);
    }

    public Computer(String nodeName, String hardwareAddress) {
        super(nodeName, hardwareAddress);
    }

    public Computer(String nodeName, String hardwareAddress, String mapLocation) {
        super(nodeName, hardwareAddress, mapLocation);
    }
    //Overrides from interface Storage
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
    //Overrides from interface Identifiable
    @Override
    public String getIp() {
        return ipAddress;
    }
    @Override
    public void setIp(String ip) {
        this.ipAddress = ipAddress;
    }
}
