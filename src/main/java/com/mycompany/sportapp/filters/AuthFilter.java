/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.filters;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import com.mycompany.sportapp.Enteties.Credentials;
import com.mycompany.sportapp.Beans.CredentialsBean;
import javax.ejb.EJB;
import javax.ws.rs.core.Response;

@Provider
public class AuthFilter implements ContainerRequestFilter {
    
    @EJB
    CredentialsBean credentialsBean;

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        
        //OM GET PASS
        //if(request.getMethod().equals("GET")){
        if(true){
            return;
        }
        
    try {
        String basicAuth = request.getHeaderString("Authorization");
        System.out.println(basicAuth);
        Credentials credentials = credentialsBean.createCredentials(basicAuth);
        if(credentialsBean.checkCredentials(credentials)){
            return;
        }
            
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        
        
        Response unAuth = Response.status(Response.Status.UNAUTHORIZED)
                .entity("Kommer du inte in? synd").build();
        request.abortWith(unAuth);
    }
}

