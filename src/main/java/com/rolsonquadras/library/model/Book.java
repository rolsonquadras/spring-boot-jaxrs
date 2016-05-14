/* Copyright (C) 2016  Rolson Quadras
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.*/


package com.rolsonquadras.library.model;

public class Book {
    private String id;
    private String author;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(final String id, final String author) {
        super();
        this.id = id;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Book [id=%s, author=%s]", id, author);
    }
}
