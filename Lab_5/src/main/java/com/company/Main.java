package com.company;

public class Main {

    public static void main(String[] args) {
	
        Catalog myCatalog = new Catalog();
        myCatalog.add(new Book("book1","My Book", "Me", "http://mysite.com/book"));
        myCatalog.add(new Book("book2","My Other Book", "Me", "http://mysite.com/book2"));
        myCatalog.save();
        //myCatalog.load("C:\\Documents\\Java\\Lab5");
    }
}
