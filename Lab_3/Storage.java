package com.company;

public interface Storage {
    void setStorage(double size);

    double getStorage();

    default double getStorageMb() {
        return getStorage() * 1024;
    }
}
