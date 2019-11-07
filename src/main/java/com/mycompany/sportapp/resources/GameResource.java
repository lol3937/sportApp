/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.resources;

import com.mycompany.sportapp.Beans.SportAppBean;
import com.mycompany.sportapp.Enteties.Game;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    
    @EJB
    SportAppBean sportAppBean;
    
    @GET
    @Path("games")
    public Response getGames() {
        List<Game> games = sportAppBean.getGames();
        return Response.ok(games).build();
    }
    
    @GET
    @Path("game")
    public Response getGame(@QueryParam("id") int id) {
        Game game = sportAppBean.getGame(id);
        return Response.ok(game).build();
    }
    
    
    //Skapa en match
    @POST
    @Path("game")
    public Response postGame(Game game) {
        int result = sportAppBean.saveGame(game);
        if (result == 1) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    //Uppdatera en match
    @PUT
    @Path("game")
    public Response updateGame(Game game) {
        int result = sportAppBean.updateGame(game);
        if (result == 1) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    
    //Ta bort en match
    @DELETE
    @Path("game")
    public Response deleteGame(@QueryParam("id") int id) {
        int result = sportAppBean.deleteGame(id);
        if (result == 1) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
