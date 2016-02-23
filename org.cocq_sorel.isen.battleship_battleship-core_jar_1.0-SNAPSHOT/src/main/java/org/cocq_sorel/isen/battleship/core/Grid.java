/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cocq_sorel.isen.battleship.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aurelien
 */
public class Grid {
    private int width;
    private int height;
    private Cell[][] cells;
    private List<Ship> ships;
    
    private static final int[] SHIP_SIZES = {2, 3, 3, 4, 5};

    public Grid(int width, int height, Cell[][] cells, List<Ship> ships) {
        this.width = width;
        this.height = height;
        this.cells = cells;
        this.ships = ships;
    }
    
    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        this.ships = new ArrayList<>();
    }
    
    public Grid(){
        this.width = 10;
        this.height = 10;
        this.cells = new Cell[width][height];
        this.ships = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
    
    public Ship getShip(int id){
        return this.ships.get(id);
    }
    
    public Cell getCell(int x, int y){
        if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight()){
            return this.cells[x][y];
        }
        else{
            return null;
        }
    }
    
    public void setCell(int x, int y, Cell cell){
        this.cells[x][y] = cell;        
    }
    
    public void initializeShips(int nbShips){        
        
        for (int i = 0; i < nbShips; i++) {
            boolean wellPlaced = false;
            int randX = 0;
            int randY = 0;
            boolean horizontal = true;
            
            while(!wellPlaced){
                randX = (int) (Math.random() * (this.getWidth() - 1));
                randY = (int) (Math.random() * (this.getHeight() - 1));
                horizontal = Math.random() < 0.5; 
                
                wellPlaced = isShipInGrid(randX, randY, Grid.SHIP_SIZES[i], horizontal) && isShipAlone(randX, randY, Grid.SHIP_SIZES[i], horizontal);
            }
                        
            addShip(i, randX, randY, Grid.SHIP_SIZES[i], horizontal);
        }
    }
    
    public boolean isShipInGrid(int x, int y, int size, boolean horizontal){
        if(horizontal){
            return (y + size - 1) < this.getWidth() && y > 0;
        }
        else{
            return (x + size - 1) < this.getHeight() && x > 0;
        }
    }

    public boolean isShipAlone(int x, int y, int size, boolean horizontal) {
        boolean isAlone = true;
        
        if(horizontal){
            int i = y;
            
            while (i < y + size && isAlone) {
                if(i == y){
                    if(this.getCell(x, i - 1) != null && this.getCell(x, i - 1).getState() == CellState.SHIP ||
                       this.getCell(x - 1, i - 1) != null && this.getCell(x - 1, i - 1).getState() == CellState.SHIP ||
                       this.getCell(x + 1, i - 1) != null && this.getCell(x + 1, i - 1).getState() == CellState.SHIP){
                        isAlone = false;
                    }
                }
                else if(i == y + size - 1){
                    if(this.getCell(x, i + 1) != null && this.getCell(x, i + 1).getState() == CellState.SHIP ||
                       this.getCell(x - 1, i + 1) != null && this.getCell(x - 1, i + 1).getState() == CellState.SHIP ||
                       this.getCell(x + 1, i + 1) != null && this.getCell(x + 1, i + 1).getState() == CellState.SHIP){
                        isAlone = false;
                    }
                }
                
                if(this.getCell(x - 1, i) != null && this.getCell(x - 1, i).getState() == CellState.SHIP ||
                   this.getCell(x + 1, i) != null && this.getCell(x + 1, i).getState() == CellState.SHIP ||
                   this.getCell(x, i) != null && this.getCell(x, i).getState() == CellState.SHIP){
                    isAlone = false;
                }
                
                i++;
            }
        }
        else{
            int i = x;
            
            while (i < x + size && isAlone) {
                if(i == x){
                    if(this.getCell(i - 1, y) != null && this.getCell(i - 1, y).getState() == CellState.SHIP ||
                       this.getCell(i - 1, y - 1) != null && this.getCell(i - 1, y - 1).getState() == CellState.SHIP ||
                       this.getCell(i - 1, y + 1) != null && this.getCell(i - 1, y + 1).getState() == CellState.SHIP){
                        isAlone = false;
                    }
                }
                else if(i == x + size - 1){
                    if(this.getCell(i + 1, y) != null && this.getCell(i + 1, y).getState() == CellState.SHIP ||
                       this.getCell(i + 1, y - 1) != null && this.getCell(i + 1, y - 1).getState() == CellState.SHIP ||
                       this.getCell(i + 1, y + 1) != null && this.getCell(i + 1, y + 1).getState() == CellState.SHIP){
                        isAlone = false;
                    }
                }
                
                if(this.getCell(i, y - 1) != null && this.getCell(i, y - 1).getState() == CellState.SHIP ||
                   this.getCell(i, y + 1) != null && this.getCell(i, y + 1).getState() == CellState.SHIP ||
                   this.getCell(i, y) != null && this.getCell(i, y).getState() == CellState.SHIP){
                    isAlone = false;
                }
                
                i++;
            }
        }
        
        return isAlone;
    }
    
    public void addShip(int shipId, int x, int y, int size, boolean horizontal){        
        ShipPart[] parts = new ShipPart[size];        
        if(horizontal){
            for (int i = 0; i < size; i++) {
                parts[i] = new ShipPart(shipId, x, y + i, CellState.SHIP);                
                this.setCell(x, y + i, parts[i]);
            }                        
        }
        else{
            for (int i = 0; i < size; i++) {
                parts[i] = new ShipPart(shipId, x + i, y, CellState.SHIP);                
                this.setCell(x + i, y, parts[i]);
            }
        }
        
        Ship newShip = new Ship(size, parts, horizontal);
        this.ships.add(newShip);
    }
    
    public void addShipsFromList(List<Ship> ships){
        for (Ship ship : ships) {
            for (ShipPart part : ship.getShipParts()) {
                this.setCell(part.getrow(), part.getcolumn(), part);
            }
            this.ships.add(ship);
        }               
    }
    
    public int getNbShipParts(){
        int nbShipParts = 0;
        for (int i = 0; i < SHIP_SIZES.length; i++) {
            nbShipParts += SHIP_SIZES[i];
        }
        
        return nbShipParts;
    }
}
