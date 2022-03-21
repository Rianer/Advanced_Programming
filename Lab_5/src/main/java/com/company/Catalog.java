package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<Item> itemList;

    Catalog(){
        itemList = new ArrayList<Item>();
    }

    public Catalog(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void add(Item newItem){
        itemList.add(newItem);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "itemList=" + itemList +
                '}';
    }

    public void save(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get("catalog.json").toFile(), itemList);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Item> toList(){
        return itemList;
    }

    public void load(String path){
        ObjectMapper mapper = new ObjectMapper();
        try {
            itemList = mapper.readValue(new File(path), Catalog.class).toList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
