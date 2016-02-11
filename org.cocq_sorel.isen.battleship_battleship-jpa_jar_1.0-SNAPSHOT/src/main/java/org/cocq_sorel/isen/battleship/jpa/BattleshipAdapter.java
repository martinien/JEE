package org.cocq_sorel.isen.battleship.jpa;

import java.math.BigDecimal;

import org.cocq_sorel.isen.battleship.core.ChipColour;
import org.cocq_sorel.isen.battleship.core.GameException;
import org.cocq_sorel.isen.battleship.core.BattleshipGame;
import org.cocq_sorel.isen.battleship.core.BattleshipGameImpl;
import org.cocq_sorel.isen.battleship.core.CellState;

public class BattleshipAdapter implements BattleshipGame {

    private Game game;
    private BattleshipGame coreGame;
    private BattleshipDAO dao;

    public BattleshipAdapter(BattleshipDAO dao, Game game) {
        this.dao = dao;
        this.game = game;
        this.coreGame = new BattleshipGameImpl();   
        

    }

    @Override
    public void fire(int row, int column) throws GameException {
        coreGame.fire(row, column);
        game.endTurn();
    }

    @Override
    public int getColumnsNumber() {
        return this.coreGame.getColumnsNumber();
    }

    @Override
    public int getRowsNumber() {
        return this.coreGame.getRowsNumber();
    }
    
    public String getToken() {
        return game.getToken();
    }
    
    public Integer getCurrentTurn(){
        return game.getCurrentTurn();
    }

    @Override
    public CellState getCellState(int row, int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean asWon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
