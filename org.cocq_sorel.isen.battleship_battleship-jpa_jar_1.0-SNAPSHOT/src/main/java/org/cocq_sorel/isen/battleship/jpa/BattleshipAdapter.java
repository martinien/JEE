package org.cocq_sorel.isen.battleship.jpa;


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
        dao.save(game);
    }

    @Override
    public int getColumnsNumber() {
        return this.coreGame.getColumnsNumber();
    }

    @Override
    public int getRowsNumber() {
        return this.coreGame.getRowsNumber();
    }
    
    @Override
     public CellState getCellState(int row, int column) {
        return this.coreGame.getCellState(row,column);   
     }

    
    @Override
    public boolean asWon() {
        return this.coreGame.asWon();
    }
    
    public String getToken() {
        return game.getToken();
    }
    
    public Integer getCurrentTurn(){
        return game.getCurrentTurn();
    }
    
   

    
    
   

  

}
