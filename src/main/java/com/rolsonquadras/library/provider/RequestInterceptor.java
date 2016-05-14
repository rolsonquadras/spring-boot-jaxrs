/* Copyright (C) 2016  Rolson Quadras
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.*/


package com.rolsonquadras.library.provider;


import java.io.IOException;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.model.ResourceModel;
import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;


@Provider
public class RequestInterceptor implements ContainerRequestFilter, ApplicationEventListener {

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        System.out.println(requestContext.getMethod());
        requestContext.getHeaders().forEach((k, v) -> System.out.println("Header :: Key = " + k + " Value = " + v));
        requestContext.getUriInfo().getMatchedResources().forEach(System.out::println);
    }

    @Override
    public void onEvent(final ApplicationEvent event) {
        switch (event.getType()) {
            case INITIALIZATION_FINISHED: {
                final Set<Class<?>> providers = event.getProviders();
                event.getResourceConfig();
                final ResourceModel resourcesModel = event.getResourceModel();
                //providers.forEach(System.out::println);
                resourcesModel.getResources().forEach(System.out::println);
                break;
            }
        }
    }

    @Override
    public RequestEventListener onRequest(final RequestEvent requestEvent) {
        // TODO Auto-generated method stub
        return null;
    }
}
