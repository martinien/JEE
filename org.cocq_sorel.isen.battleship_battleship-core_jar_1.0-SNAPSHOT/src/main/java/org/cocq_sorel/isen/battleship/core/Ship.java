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
 * @author Aurelien
 */
public class Ship implements Serializable{
    private int size;    
    private ShipPart[] shipParts;
    private boolean horizontal;

    public Ship() {
        this.size = 3;        
        this.shipParts = new ShipPart[this.size];
    }
    
    public Ship(int size){
        this.size = size;
        this.shipParts = new ShipPart[this.size];
    }

    public Ship(int size, ShipPart[] shipParts, boolean horizontal) {
        this.size = size;        
        this.shipParts = shipParts;
        this.horizontal = horizontal;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ShipPart[] getShipParts() {
        return shipParts;
    }

    public void setShipParts(ShipPart[] shipParts) {
        this.shipParts = shipParts;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    
    public int getNbHitParts(){
        int nbHitParts = 0;
        
        for (int i = 0; i < this.getSize(); i++) {
            if(this.getShipParts()[i].getState() == CellState.HITSHIP){                
                nbHitParts++;
            }
        }
        
        return nbHitParts;
    }
    
    public void sinkShip(){
        for (int i = 0; i < shipParts.length; i++) {
            shipParts[i].setState(CellState.SUNKSHIP);
        }
    }
    
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(size);
        out.writeBoolean(horizontal);
        out.writeObject(shipParts);
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        size = in.readInt();
        horizontal = in.readBoolean();
        shipParts = (ShipPart[]) in.readObject();
    }
     
}
