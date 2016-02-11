package org.cocq_sorel.isen.battleship.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.cocq_sorel.isen.battleship.core.ChipColour;


@Entity(name="Game")
public class Game {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String token;   
    

    private Integer currentTurn;

    public Game() {
        currentTurn = 0;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }

   
    public Integer getCurrentTurn() {
       return currentTurn ;
    }
    
    public void endTurn(){
        currentTurn ++ ;
    }

}
