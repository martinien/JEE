/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cocq_sorel.isen.battleship.core;

/**
 *
 * @author martinien
 */
public interface BattleshipGame {
    
    /**
	 * Fire a bomb at (row, column) coordinates.
	 * @param row
	 * @param column
	 * @throws GameException if it is not allowed to play in that cell.
	 */
    void fire(int row, int column) throws GameException;
    
    /**
     * Returns the number of columns.
     * @return
     */
    int getColumnsNumber();

    /**
     * Returns the number of rows.
     * @return
     */
    int getRowsNumber();
    
}
