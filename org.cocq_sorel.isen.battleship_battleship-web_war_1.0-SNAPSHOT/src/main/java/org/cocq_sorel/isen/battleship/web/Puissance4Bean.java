package org.cocq_sorel.isen.battleship.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.cocq_sorel.isen.battleship.core.ChipColour;
import org.cocq_sorel.isen.battleship.core.Puissance4Game;
import org.cocq_sorel.isen.battleship.core.Puissance4GameImpl;
import org.cocq_sorel.isen.battleship.jpa.Puissance4Adapter;
import org.cocq_sorel.isen.battleship.jpa.Puissance4DAO;

@Named("game")
@RequestScoped
public class Puissance4Bean implements Serializable {

    Puissance4Adapter game ;

    @Inject
    Puissance4DAO dao;


    public List<Puissance4Column> getColumns() {

        List<Puissance4Column> cols = new ArrayList<>();
        for (int i = 0; i < game.getColumnsNumber(); i++) {
            cols.add(new Puissance4Column(i, game));
        }
        return cols;

    }

    public void play(int col) {
        game.play(game.getCurrentTurn(), col);

    }



    public void reset() {


    }

    public ChipColourWrapper getWinner() {
        if (game.getWinner() != null) {
            return new ChipColourWrapper(game.getWinner());
        } else {
            return null;
        }
    }

    public Puissance4Game getGame() {
        return game;
    }

    public void createNewGame() {
        game = dao.createNewGame();

    }

    public String getToken() {
        return game.getToken();
    }

    public void loadFromToken(String token) {
        game = dao.loadFromToken(token);

    }

}
