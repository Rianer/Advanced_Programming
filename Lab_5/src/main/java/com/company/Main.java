package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Catalog myCatalog = new Catalog();
        myCatalog.add(new Book("book2","My Book", "Me", "http://mysite.com/book"));
        myCatalog.save();
        //myCatalog.load("C:\\Documents\\Java\\Lab5");
    }
}
