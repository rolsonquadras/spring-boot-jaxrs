/* Copyright (C) 2016  Rolson Quadras
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.*/


package com.rolsonquadras.library.controller;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rolsonquadras.library.model.Book;


@Path("/admin/library/book")
public class LibraryController {

    private static final Map<Integer, Book> library = new HashMap<>();

    static {
        library.put(1001, new Book("1001", "Hamish Marsh"));
        library.put(1002, new Book("1002", "Adam McMahon"));
        library.put(1003, new Book("1003", "Brendon Clark"));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook(@PathParam("id") final Integer id) {
        return Response.ok(library.get(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks(@PathParam("id") final Integer id) {
        return Response.ok(library).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(final Book book) {
        library.put(Integer.parseInt(book.getId()), book);
        return Response.created(URI.create("/" + book.getId())).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(final Book book) {
        library.put(Integer.parseInt(book.getId()), book);
        return Response.created(URI.create("/" + book.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") final Integer id) {
        return Response.ok(library.remove(id) != null ? true : false).build();
    }
}
