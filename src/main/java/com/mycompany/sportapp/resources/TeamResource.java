package com.mycompany.sportapp.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("team")
public class TeamResource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }

}
