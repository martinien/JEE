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


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String token;   
    
    private List<Turn> turns; 
    private List<Ship> ships;

    public Game() {        
        turns = new ArrayList<>();
        ships = new ArrayList<>();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }
    
    public void endTurn(){
        
    }
    
    
    public List<Turn> getTurns(){
        return this.turns;
    }
    
    public List<Ship> getShips(){
        return ships;
    }
    
    public Integer getCurrentTurn(){
        return getTurns().size();
    }

}
