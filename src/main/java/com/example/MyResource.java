package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        return "This is text.";
    }
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceMessage getJson() {
    	return new ServiceMessage("This is JSON");
    }
    @POST
    @Path("json/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceMessage postJson(@PathParam("id") String id, ServiceMessage postData) {
    	ServiceMessage result = new ServiceMessage(id + ":" + postData.getText());
    	return result;
    }
    
    @PUT
    @Path("json")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceMessage putJson(ServiceMessage putData) {
    	ServiceMessage result = new ServiceMessage(putData.getText() + " response");
    	return result;
    }
}
