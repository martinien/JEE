/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cocq_sorel.isen.battleship.core;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Aurelien
 */
public class BattleshipGameTest {
    private BattleshipGame game; 
    
    @Before
    public void doBefore() throws Exception {
        game = new BattleshipGameImpl(null);
    }
    
    @Test
    public void aPlayerMayFire() throws Exception {
        game.fire(1, 1);
        assertThat(game.getCellState(1, 1)).isIn(Arrays.asList(CellState.HITSHIP, CellState.HITWATER));
        
        game.fire(5, 5);
        assertThat(game.getCellState(5, 5)).isIn(Arrays.asList(CellState.HITSHIP, CellState.HITWATER));
    }
    
    @Test
    public void itCantPlayOutsideOfTheBoard() throws Exception {
        try {
            game.fire(15, 15);
            fail("It is not possible to play outside of the board");
        } catch (GameException e) {

        }

        try {
            for (int i = 0; i <= game.getRowsNumber(); i++) {
                game.fire(3, 22);
            }
            fail("It is not possible to play outside of the board");
        } catch (GameException e) {

        }

    }
    
    @Test
    public void thereAreSevenTeenShipPartsOnTheBoard() throws Exception{
        int nbShipParts = 0;
        
        for (int i = 0; i < game.getRowsNumber(); i++) {
            for (int j = 0; j < game.getColumnsNumber(); j++) {
                if(game.getCellState(i, j) == CellState.SHIP){                    
                    nbShipParts++;
                }
            }
        }
        
        assertThat(nbShipParts).isEqualTo(17);
    }
    
    @Test
    public void aPlayerCanWinTheGame() throws Exception{
        assertThat(game.asWon()).isEqualTo(false);
        
        for (int i = 0; i < game.getRowsNumber(); i++) {
            for (int j = 0; j < game.getColumnsNumber(); j++) {
                if(game.getCellState(i, j) == CellState.SHIP){                    
                    game.fire(i, j);                    
                }
            }
        }

        assertThat(game.asWon()).isEqualTo(true);
    }
}
