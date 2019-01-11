package commands;

import commands.contracts.Command;
import commands.creation.LostShipCommand;
import constants.GameBoard;
import core.contracts.Engine;
import core.factories.Factory;
import ships.ShipBase;
import ships.shipContracts.LostShip;
import ships.shipContracts.Ship;
import ships.shipContracts.StarShipColonial;
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
    private long totalPopulation = 0;
    private int colonizedPlanets = 0;

    public String execute(List<String> parameters) {


        try {
            jumpYears = Integer.parseInt(parameters.get(0));
        } catch (Exception e) {
            jumpYears = 1;
        }

        if (jumpYears < 1) {
            jumpYears = 1;
        }

        GameBoard.year += this.jumpYears;



        updateTurnsToDestination();

        updateSpaceObjects();

        Extinction();

        updateResource();

        return printReport();

    }

    private void updateResource() {
        for (Ship ship : engine.getShip()) {
            ship.next();
        }
    }

    private void updateTurnsToDestination() {
        for (Ship ship : engine.getShip()) {
            if (ship.getTurnsToDestination() > 0) {
                ((ShipBase) ship).setTurnsToDestination(ship.getTurnsToDestination() - jumpYears);
                if (ship.getTurnsToDestination() <= 0) {
                    buildColony(ship);
                }
            }
        }
    }

    private void buildColony(Ship ship) {
        if (ship instanceof StarShipColonial) {
            System.out.println(ship.getShipName() + " build new colony" + System.lineSeparator());
            ((Planet) engine.getSpaceObject().get(ship.getDestination())).setPopulation(((StarShipColonial) ship).getCrewCount());
            new LostShipCommand(factory, engine).executeCall(engine.getShip().indexOf(ship));
        }
    }

    private void updateSpaceObjects() {

        for (SpaceObject spaceObject : engine.getSpaceObject()) {
            if (spaceObject instanceof Planet) {
                totalPopulation = totalPopulation + ((Planet) spaceObject).getPopulation();
                if (((Planet) spaceObject).getPopulation() > 0) {
                    colonizedPlanets++;
                }
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

    private void Extinction() {
        int yearsBeforeAfterExtinction = GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear();

        if (yearsBeforeAfterExtinction <= 0 && GameBoard.loadCounter > 0) {
            for (SpaceObject spaceObject : engine.getSpaceObject()) {
                if (spaceObject instanceof Planet && ((Planet) spaceObject).getObjectName().equals("Earth")) {
                    ((Planet) spaceObject).setPopulation(0);
                }
            }
        }
    }

    private String printReport() {
        int yearsBeforeAfterExtinction = GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear();

        int totalShips = engine.getShip().size();
        int activeShips = totalShips - LostShips();

        String BeforeAfterExtinction = yearsBeforeAfterExtinction > 0 ? "before" : "after";
        yearsBeforeAfterExtinction = Math.abs(yearsBeforeAfterExtinction);
        String singleOrPlural = yearsBeforeAfterExtinction <= 1 ? "%d year " : "%d years ";
        String numberOfyearsBeforeAfter = yearsBeforeAfterExtinction == 0 ? "Extinction Level Event" : String.format((singleOrPlural + BeforeAfterExtinction + " Extinction Level Event"), yearsBeforeAfterExtinction);

        return String.format(
                "Year: %d" + System.lineSeparator() +
                        numberOfyearsBeforeAfter + System.lineSeparator() +
                        "Known Space Objects   : %d" + System.lineSeparator() +
                        "Colonized planets     : %d" + System.lineSeparator() +
                        "Total Population      : %d " + System.lineSeparator() +
                        "**************************" + System.lineSeparator() +
                        "Total number of ships : %d " + System.lineSeparator() +
                        "   Active ships       : %d " + System.lineSeparator() +
                        "   Lost ships         : %d " + System.lineSeparator() +
                        "**************************" + System.lineSeparator(),
                GameBoard.getYear(), engine.getSpaceObject().size(), colonizedPlanets, totalPopulation, totalShips, activeShips, LostShips());
    }


}


