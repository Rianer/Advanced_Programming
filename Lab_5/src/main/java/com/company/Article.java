package com.company;

public class Article extends Item {
    public Article(String id, String title, String author, String location) {
        super(id, title, author, location);
        this.type = "article";
    }
}
