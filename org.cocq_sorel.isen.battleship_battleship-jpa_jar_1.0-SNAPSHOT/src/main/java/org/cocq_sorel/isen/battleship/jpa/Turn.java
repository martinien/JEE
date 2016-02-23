package org.cocq_sorel.isen.battleship.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @ManyToOne
    Game game;    
    
    @Column(name="col")
    private int column; 
    
    @Column(name="row")
    private int row;
    
    public Turn() {

    }

    public Turn(Game game, int row, int column) {
        this.game = game;
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn() {
        return column;
    }


}
