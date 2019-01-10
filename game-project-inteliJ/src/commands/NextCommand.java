package commands;

import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.Factory;
import ships.ShipBase;
import ships.shipContracts.LostShip;
import ships.shipContracts.Ship;
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

    private int jumpYears;
    private int totalPopulation = 0;

    public String execute(List<String> parameters) {
//        int totalShips = engine.getShip().size();
//        int activeShips = totalShips - LostShips();


        try {
            jumpYears = Integer.parseInt(parameters.get(0));
            GameBoard.year+=this.jumpYears ;
            updateResourceWithYear();
        } catch (Exception e) {
            GameBoard.year++;
        }


        updateTurnsToDestination();

        updateSpaceObjects();

        updateResource();

        return printReport();

    }

    private void updateResource() {
        for (Ship ship : engine.getShip()) {
            ship.next();
        }
    }
    private void updateResourceWithYear() {
        for (Ship ship : engine.getShip()) {
            ship.next(this.jumpYears);
        }
    }


    private void updateTurnsToDestination() {
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

    private int LostShips() {
        int counterLostShip = 0;
        for (Ship ship : engine.getShip()) {
            if (ship instanceof LostShip) {
                counterLostShip++;
            }
        }
        return counterLostShip;
    }

    private String printReport() {
        int yearsBeforeAfterExtinction = GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear();

        String BeforeAfterExtinction = yearsBeforeAfterExtinction > 0 ? "before" : "after";
        yearsBeforeAfterExtinction = Math.abs(yearsBeforeAfterExtinction);
        String singleOrPlural = yearsBeforeAfterExtinction <= 1 ? "%d year " : "%d years ";
        String numberOfyearsBeforeAfter = yearsBeforeAfterExtinction == 0 ? "Extinction Level Event" : String.format((singleOrPlural + BeforeAfterExtinction + " Extinction Level Event"), yearsBeforeAfterExtinction);

        return String.format(
                "Year: %d" + System.lineSeparator() +
                        numberOfyearsBeforeAfter + System.lineSeparator() +
                        "Known Space Objects   : %d" + System.lineSeparator() +
                        "Total Population      : %d " + System.lineSeparator() +
                        "**************************" + System.lineSeparator() +
                        "Total number of ships : %d " + System.lineSeparator() +
                        "   Active ships       : %d " + System.lineSeparator() +
                        "   Lost ships         : %d " + System.lineSeparator() +
                        "**************************" + System.lineSeparator(),
                GameBoard.getYear(), engine.getSpaceObject().size(), totalPopulation, engine.getShip().size(), engine.getShip().size() - LostShips(), LostShips());
    }


}


