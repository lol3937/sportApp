/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.Beans;

import com.mycompany.sportapp.Enteties.Credentials;

import java.util.Base64;
import javax.ejb.Stateless;

@Stateless
public class CredentialsBean {

    public Credentials createCredentials(String basicAuth) {
        basicAuth = basicAuth.substring(6).trim();
        byte[] bytes = Base64.getDecoder().decode(basicAuth);
        basicAuth = new String(bytes);
        int colonPos = basicAuth.indexOf(":");
        String username = basicAuth.substring(0, colonPos);
        String password = basicAuth.substring(colonPos + 1);
        return new Credentials(username, password);
    }

    public boolean checkCredentials(Credentials credentials) {
        if (credentials.getUsername().equals("Joel") && 
            credentials.getPassword().equals("Secret")) {
            return true;
        }
        return false;
    }
}

