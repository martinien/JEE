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
public class ShipPart extends Cell{
    private int shipId;
    
    public ShipPart(int shipId, int Collumn, int Row, CellState state) {
        super(Collumn, Row, state);
        
        this.shipId = shipId;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }
    
    
}
