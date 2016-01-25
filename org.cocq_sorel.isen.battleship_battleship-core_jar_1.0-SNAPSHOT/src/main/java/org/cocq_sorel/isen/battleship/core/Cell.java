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
public class Cell {
    
    private int column;
    private int row;
    private CellState state;

    public Cell(int column, int row, CellState state) {
        this.column = column;
        this.row = row;
        this.state = state;
    }

    public int getcolumn() {
        return column;
    }

    public void setcolumn(int column) {
        this.column = column;
    }

    public int getrow() {
        return row;
    }

    public void setrow(int row) {
        this.row = row;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
    
    
    
    
    
    
}
