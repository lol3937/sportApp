
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.Beans;

import com.mycompany.sportapp.ConnectionFactory;
import com.mycompany.sportapp.Enteties.Game;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class SportAppBean {
    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Game";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("id");
                int away_team = data.getInt("away_team");
                int home_team = data.getInt("home_team");
                int away_point = data.getInt("away_point");
                int home_point = data.getInt("home_point");
                Game game = new Game(id, away_team, home_team, home_point, away_point);
                games.add(game);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return games;
}
    public int saveGame(Game game) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO game VALUES(NULL,%d,%d,%d,%d)",
                    game.getAway_team(), game.getHome_team(), game.getAway_point(), game.getHome_point());
            return stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
    
    public int updateGame(Game game) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format
        ("UPDATE game SET away_team = %d,"
                + " home_team = %d, away_point = %d, home_point = %d WHERE id=%d",
                    game.getAway_team(), game.getHome_team(), game.getAway_point(), game.getHome_point(),game.getId());
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }

    //för specifikt en match
    public Game getGame(int id) {
        Game game = new Game();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Game WHERE id= " + id;
            System.out.println(sql);
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int away_team = data.getInt("away_team");
                int home_team = data.getInt("home_team");
                int away_point = data.getInt("away_point");
                int home_point = data.getInt("home_point");
                game = new Game
                        (id, away_team, home_team, home_point, away_point);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return game;
    }

    public int deleteGame(int id) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format
        ("DELETE FROM game WHERE id = %d",id);
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}
