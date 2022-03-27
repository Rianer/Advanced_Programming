package com.company;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Article extends Item {
    @JsonCreator
    public Article(@JsonProperty("id") String id, @JsonProperty("title") String title,
                   @JsonProperty("author") String author, @JsonProperty("location") String location) {
        super(id, title, author, location);
        this.type = "article";
    }
}
