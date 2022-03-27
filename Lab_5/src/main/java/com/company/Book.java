package com.company;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book extends Item{
    @JsonCreator
    public Book(@JsonProperty("id") String id, @JsonProperty("title") String title,
                @JsonProperty("author") String author, @JsonProperty("location") String location) {
        super(id, title, author, location);
        this.type = "book";
    }
}
