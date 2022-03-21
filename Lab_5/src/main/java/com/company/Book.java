package com.company;

public class Book extends Item{
    public Book(String id, String title, String author, String location) {
        super(id, title, author, location);
        this.type = "book";
    }
}
