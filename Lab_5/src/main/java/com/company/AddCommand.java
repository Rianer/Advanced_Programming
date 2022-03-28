package com.company;

import java.util.List;

public abstract class AddCommand extends ItemList { //command for adding a new Item to the list
    public void addItem(Item item){
        list.add(item);
    }
}
