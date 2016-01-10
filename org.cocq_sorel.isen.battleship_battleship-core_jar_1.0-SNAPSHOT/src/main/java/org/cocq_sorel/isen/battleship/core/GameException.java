package org.cocq_sorel.isen.battleship.core;

/**
 * Created by dmetzler on 04/09/2014.
 */
public class GameException extends RuntimeException {
    private final String message;

    public GameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
