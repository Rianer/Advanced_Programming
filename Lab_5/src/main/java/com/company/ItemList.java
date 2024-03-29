package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemList { //Abstract class which describes a list of Items
    String name;
    List<Item> list;

    public ItemList(String name, ArrayList<Item> list) {
        this.name = name;
        this.list = list;
    }

    public ItemList() {
    }

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
