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
public class ShipPart extends Cell implements Serializable{
    private int shipId;
    
    public ShipPart(){
        super();
        
        this.shipId = 0;
    }
    
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
    
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(shipId);
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {

        shipId = in.readInt();
    }
    
}
