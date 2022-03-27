package com.company;

import java.util.List;

public abstract class AddCommand extends ItemList {
    public void addItem(Item item){
        list.add(item);
    }
}
