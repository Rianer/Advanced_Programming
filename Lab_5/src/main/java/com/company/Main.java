package com.company;

public class Main {

    public static void main(String[] args) {

        Catalog myCatalog = new Catalog();
        myCatalog.load("C:\\Documents\\Java\\Lab5\\catalog.json");
        myCatalog.addItem(new Article("article1", "Java", "Peter Parker", "C:\\Desktop"));
        myCatalog.addItem(new Article("article2", "HTML/CSS", "Bruce Wayne", "http://www.gotham.com/article2"));

        myCatalog.save("C:\\Documents\\Java\\Lab5\\backup.json");

        myCatalog.list();
        myCatalog.view("C:\\Documents\\Java\\Lab5\\catalog.json");
        myCatalog.report();
    }
}
