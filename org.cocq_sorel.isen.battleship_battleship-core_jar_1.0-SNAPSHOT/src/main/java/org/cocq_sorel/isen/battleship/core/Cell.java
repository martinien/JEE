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
    
    private int Collumn;
    private int Row;
    private CellState state;

    public Cell(int Collumn, int Row, CellState state) {
        this.Collumn = Collumn;
        this.Row = Row;
        this.state = state;
    }

    public int getCollumn() {
        return Collumn;
    }

    public void setCollumn(int Collumn) {
        this.Collumn = Collumn;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int Row) {
        this.Row = Row;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
    
    
    
    
    
    
}
