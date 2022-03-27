package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Catalog myCatalog = new Catalog();
        myCatalog.load("C:\\Documents\\Java\\Lab5\\catalog.json");
        myCatalog.addItem(new Article("article1", "Java", "Peter Parker", "C:\\Desktop"));
        myCatalog.addItem(new Article("article2", "HTML/CSS", "Bruce Wayne", "www.gotham.com/article2"));

        //myCatalog.add(new Book("book1","My Book", "Me", "http://mysite.com/book"));
        //myCatalog.add(new Book("book2","My Other Book", "Me", "http://mysite.com/book2"));

        myCatalog.save("C:\\Documents\\Java\\Lab5\\backup.json");

        myCatalog.list();
        myCatalog.view("C:\\Documents\\Java\\Lab5\\backup.json");
        myCatalog.report();
    }
}
