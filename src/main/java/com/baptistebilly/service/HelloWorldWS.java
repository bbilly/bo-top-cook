package com.baptistebilly.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloWorldWS {
	
	 @GET
	 @Path("hello")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String connexion() {
		 return "Hello World !";
	}

}
