package commands;

import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.Factory;
import ships.ShipBase;
import ships.shipContracts.Ship;
import spaceObjects.contracts.AsteroidField;
import spaceObjects.contracts.Planet;
import spaceObjects.contracts.SpaceObject;

import java.util.List;


public class NextCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public NextCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;

    }

    private int totalPopulation = 0;
    private int yearsBeforeAfterExtinction = GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear();

    public String execute(List<String> parameters) {
        GameBoard.year++;

        updateShips();

        updateSpaceObjects();

        return printReport();

    }


    private void updateShips() {
        for (Ship ship : engine.getShip()) {
            if (ship.getTurnsToDestination() > 0) {
                ((ShipBase) ship).setTurnsToDestination(ship.getTurnsToDestination() - 1);

            }
        }
    }

    private void updateSpaceObjects() {
        for (SpaceObject spaceObject : engine.getSpaceObject()) {
            if (spaceObject instanceof Planet) {
                totalPopulation = totalPopulation + ((Planet) spaceObject).getPopulation();

            }
        }
    }

    private String printReport() {
        String BeforeAfterExtinction = yearsBeforeAfterExtinction > 0 ? "before" : "after";
        yearsBeforeAfterExtinction = Math.abs(yearsBeforeAfterExtinction);
        String singleOrPlural = yearsBeforeAfterExtinction <= 1 ? "%d year " : "%d years ";
        String numberOfyearsBeforeAfter = yearsBeforeAfterExtinction == 0 ? "Extinction Level Event" : String.format((singleOrPlural + BeforeAfterExtinction + " Extinction Level Event"), yearsBeforeAfterExtinction);

        return String.format(
                "Year: %d" + System.lineSeparator() +
                        numberOfyearsBeforeAfter + System.lineSeparator() +
                        "Known Space Objects : %d" + System.lineSeparator() +
                        "Total Population  : %d " + System.lineSeparator() +
                        "Total number of ships : %d " + System.lineSeparator() +
                        "********************",
                GameBoard.getYear(), engine.getSpaceObject().size(), totalPopulation, engine.getShip().size());
    }


}


