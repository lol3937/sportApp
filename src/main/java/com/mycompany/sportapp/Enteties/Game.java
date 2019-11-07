/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.Enteties;

/**
 *
 * @author T4User
 */
public class Game {
    private int id;
    private int away_team;
    private int home_team;
    private int home_point;
    private int away_point;

    public Game() {
    }

    public Game(int id, int away_team, int home_team, int home_point, int away_point) {
        this.id = id;
        this.away_team = away_team;
        this.home_team = home_team;
        this.home_point = home_point;
        this.away_point = away_point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAway_team() {
        return away_team;
    }

    public void setAway_team(int away_team) {
        this.away_team = away_team;
    }

    public int getHome_team() {
        return home_team;
    }

    public void setHome_team(int home_team) {
        this.home_team = home_team;
    }

    public int getHome_point() {
        return home_point;
    }

    public void setHome_point(int home_point) {
        this.home_point = home_point;
    }

    public int getAway_point() {
        return away_point;
    }

    public void setAway_point(int away_point) {
        this.away_point = away_point;
    }
    
    
}
