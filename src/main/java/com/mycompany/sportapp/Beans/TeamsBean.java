/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.Beans;

import com.mycompany.sportapp.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.sportapp.Enteties.Team;


public class TeamsBean {
    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Teams";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                Team team = new Team(id, name);
                teams.add(team);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return teams;
}
    public int saveEnemy(Team team) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO teams VALUES(NULL,'%s',%d)",
                  team.getName());
            return stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
    
    public int updateEnemy(Team team) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format
        ("UPDATE team SET name = '%s', name = '%s' WHERE id=%d",
                    team.getName());
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}
