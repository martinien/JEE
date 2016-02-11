package org.cocq_sorel.isen.battleship.web;



import org.cocq_sorel.isen.battleship.web.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.cocq_sorel.isen.battleship.core.BattleshipGame;
import org.cocq_sorel.isen.battleship.core.BattleshipGameImpl;
import org.cocq_sorel.isen.battleship.core.CellState;
import org.cocq_sorel.isen.battleship.jpa.BattleshipAdapter;
import org.cocq_sorel.isen.battleship.jpa.BattleshipDAO;

@Named("game")
@RequestScoped
public class BattleshipBean implements Serializable {

    BattleshipAdapter game ;

    @Inject
    BattleshipDAO dao;


    
    public List<String> getCells(){
        List<String> l =new ArrayList<>();
        int rows,collumns,r,c;
        rows = getRowsNumber();
        collumns = getCollumnsNumber();
        for(c=0;c<collumns;c++){
            for(r=0;r<rows;r++){
                l.add(getCellStatus(r,c).toString());
            }
        }
        
        return l;
    }
    
    
     

    
    
    public void hit(int row,int col){
        game.fire(row, col);
    }
    
    public CellState getCellStatus(int row,int col){
        return game.getCellState(row, col);
        
    }
    
    public int getCollumnsNumber(){
        return game.getColumnsNumber();
    }
    
    public int getRowsNumber(){
        return game.getRowsNumber();
    }



    public void reset() {

    }



    public BattleshipGame getGame() {
        return game;
    }

    public void createNewGame() {
        game = dao.createNewGame();

    }

    public String getToken() {
        return game.getToken();
    }

    public void loadFromToken(String token) {
        game = dao.loadFromToken(token);

    }
    
    public String getStateColor(CellState state){
        switch(state){
            case SHIP:
                return "grey";
            case WATER:
                return "grey";
            case HITSHIP:
                return "red";
            case HITWATER:
                return "blue";
            case SUNKSHIP:
                return "black";
            default:
                return "grey";
        }
    }

}
