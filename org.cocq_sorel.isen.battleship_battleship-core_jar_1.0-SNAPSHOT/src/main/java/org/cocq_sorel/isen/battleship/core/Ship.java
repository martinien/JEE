/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cocq_sorel.isen.battleship.core;

/**
 *
 * @author Aurelien
 */
public class Ship {
    private int size;    
    private ShipPart[] shipParts;

    public Ship() {
        this.size = 3;        
        this.shipParts = new ShipPart[this.size];
    }
    
    public Ship(int size){
        this.size = size;
        this.shipParts = new ShipPart[this.size];
    }

    public Ship(int size, ShipPart[] shipParts) {
        this.size = size;        
        this.shipParts = shipParts;
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

    public boolean isSunk() {
        boolean sunk = true;
        int shipPartId = 0;
        
        while(sunk = true && shipPartId < this.getSize()){
            if(this.getShipParts()[shipPartId].getState() == CellState.SHIP){
                sunk = false;
            }
            shipPartId++;
        }
        
        return sunk;
    }
     
}
