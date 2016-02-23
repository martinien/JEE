/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cocq_sorel.isen.battleship.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author martinien
 */
public class Cell implements Serializable{
    
    private int column;
    private int row;
    private CellState state;
    
    public Cell(){
        this.column = 0;
        this.row = 0;
        this.state = CellState.WATER;
    }

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
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(row);
        out.writeInt(column);        
        out.writeInt(state.ordinal());
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        row = in.readInt();
        column = in.readInt();
        state = intToState(in.readInt());     
    }
    
    public CellState intToState(int value){
        switch(value){
            case 0:
                return CellState.WATER;
            case 1:
                return CellState.HITWATER;
            case 2:
                return CellState.SHIP;
            case 3:
                return CellState.HITSHIP;
            case 4:
                return CellState.SUNKSHIP;
            default:
                return CellState.WATER;
        }
    }
    
    
}
