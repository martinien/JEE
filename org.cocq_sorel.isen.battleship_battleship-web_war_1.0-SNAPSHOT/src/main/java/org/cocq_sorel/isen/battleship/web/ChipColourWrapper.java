package org.cocq_sorel.isen.battleship.web;

import org.cocq_sorel.isen.battleship.core.ChipColour;

public class ChipColourWrapper {

    private ChipColour cell;

    public ChipColourWrapper(ChipColour cell) {
        this.cell = cell;
    }

    public String getCssColor() {
        if(ChipColour.YELLOW == cell) {
            return "yellow";
        } else if(ChipColour.RED ==cell) {
            return "red";
        } else {
            return "";
        }
    }

}
