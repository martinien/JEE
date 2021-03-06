/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cocq_sorel.isen.battleship.core;

import java.util.List;

/**
 *
 * @author Aurelien
 */
public class BattleshipGameImpl implements BattleshipGame{
    
    public static final int COLUMNS_NUMBER = 10;
    public static final int ROWS_NUMBER = 10;
    public static final int SHIPS_NUMBER = 5;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
    
    Grid board;
    
    public BattleshipGameImpl(List<Ship> ships){
        board = new Grid(COLUMNS_NUMBER, ROWS_NUMBER);
        initBoard(ships);
    }
    
    private void initBoard(List<Ship> ships) {

        for (int i = 0; i < ROWS_NUMBER; i++) {
            for (int j = 0; j < COLUMNS_NUMBER; j++) {
                board.setCell(i, j, new Cell(i, j, CellState.WATER));
            }
        }               
        
        if(ships == null){
            board.initializeShips(SHIPS_NUMBER);            
        }
        else{                        
            for (Ship ship : ships) {                  
                board.addShipsFromList(ships);
            }
        }
    }

    @Override
    public int getColumnsNumber() {
        return COLUMNS_NUMBER;
    }

    @Override
    public int getRowsNumber() {
        return ROWS_NUMBER;
    }
    
    public int getShipsNumber(){
        return SHIPS_NUMBER;
    }

    @Override
    public void fire(int row, int column) throws GameException {
        if(row < 0 || row >= getRowsNumber() || column < 0 || column >= getColumnsNumber()){
            throw new GameException(OUTSIDE_OF_BOARD_ERROR);
        }
        
        Cell firedCell = board.getCell(row, column);
                
        switch(firedCell.getState()){
            case WATER:
                board.getCell(row, column).setState(CellState.HITWATER);
                break;
            case SHIP:
                firedCell.setState(CellState.HITSHIP);
                ShipPart part = (ShipPart) firedCell;
                Ship hitShip = board.getShip(part.getShipId());
                
                if(hitShip.getNbHitParts() == hitShip.getSize()){                    
                    hitShip.sinkShip();
                }                            
                break;
            default:
                break;
        }
    }

    @Override
    public CellState getCellState(int row, int column) {
        return this.board.getCell(row, column).getState();        
    }

    @Override
    public boolean asWon() {        
        int nbSunkShipPart = 0;
        
        for (int i = 0; i < ROWS_NUMBER; i++) {
            for (int j = 0; j < COLUMNS_NUMBER; j++) {
                if(board.getCell(i, j).getState() == CellState.SUNKSHIP){
                    nbSunkShipPart++;
                }
            }            
        }
        
        return nbSunkShipPart == board.getNbShipParts();
    }

    @Override
    public List<Ship> getShips() {
        return board.getShips();
    }
    
}
