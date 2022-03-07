package com.company;

public interface Storage {
    void storeData(String data, double size);
    String getData(int index);
    double getDataSize(int index);
}
