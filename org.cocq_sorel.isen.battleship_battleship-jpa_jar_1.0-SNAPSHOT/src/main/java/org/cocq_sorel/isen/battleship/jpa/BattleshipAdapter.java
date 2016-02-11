package org.cocq_sorel.isen.battleship.jpa;


import java.util.List;
import org.cocq_sorel.isen.battleship.core.GameException;
import org.cocq_sorel.isen.battleship.core.BattleshipGame;
import org.cocq_sorel.isen.battleship.core.BattleshipGameImpl;
import org.cocq_sorel.isen.battleship.core.CellState;
import org.cocq_sorel.isen.battleship.core.Ship;

public class BattleshipAdapter implements BattleshipGame {

    private Game game;
    private BattleshipGame coreGame;
    private BattleshipDAO dao;

    public BattleshipAdapter(BattleshipDAO dao, Game game) {
        this.dao = dao;
        this.game = game;
        
        if(game.getShips().size() == 0){            
            this.coreGame = new BattleshipGameImpl(null);
            game.getShips().addAll(this.coreGame.getShips());
        }
        else{
            this.coreGame = new BattleshipGameImpl(game.getShips());
        }

        for (Turn turn : game.getTurns()) {
            this.coreGame.fire(turn.getRow(), turn.getColumn());
        }
    }

    @Override
    public void fire(int row, int column) throws GameException {
        coreGame.fire(row, column);
        this.game.getTurns().add(new Turn(this.game, row, column));
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

    @Override
    public List<Ship> getShips() {
        return this.coreGame.getShips();
    }
}
