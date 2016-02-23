package org.cocq_sorel.isen.battleship.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.cocq_sorel.isen.battleship.core.Ship;


@Entity(name="Game")
public class Game {
    private static final int NB_MAX_TURN = 50;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String token;   
    
    private List<Turn> turns; 
    private List<Ship> ships;
    private int nbTurnLeft;

    public Game() {        
        turns = new ArrayList<>();
        ships = new ArrayList<>();
        nbTurnLeft = NB_MAX_TURN;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }
    
    public void endTurn(){
        nbTurnLeft--;
    }
    
    
    public List<Turn> getTurns(){
        return this.turns;
    }
    
    public List<Ship> getShips(){
        return ships;
    }
    
    public Integer getNbTurnLeft(){
        return nbTurnLeft;
    }

}
