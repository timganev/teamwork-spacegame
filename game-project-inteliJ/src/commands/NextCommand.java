package commands;

import commands.contracts.Command;
import commands.creation.LostShipCommand;
import constants.Constants;
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

        Constants.YEAR += this.jumpYears;



        updateTurnsToDestination();

        updateSpaceObjects();

        extinction();

        updateResource();

        return printReport();

    }

    private void updateResource() {
        for (Ship ship : engine.getShip()) {
            ship.next(this.jumpYears);
        }
    }

    private void updateTurnsToDestination() {
        for (Ship ship : engine.getShip()) {
            if (ship.getTurnsToDestination() > 0) {
                ((ShipBase) ship).setTurnsToDestination(ship.getTurnsToDestination() - jumpYears);
                if (ship.getTurnsToDestination() <= 0) {
                    arriveAtDestination(ship);
                }
            }
        }
    }

    private void arriveAtDestination(Ship ship) {
        String shipname = ship.getShipName();
        int shipId = engine.getShip().indexOf(ship);
        int destination =  ship.getDestination();
        String destinationName = engine.getSpaceObject().get(destination).getObjectName();

        if (ship instanceof StarShipColonial) {
            int population = ((StarShipColonial) ship).getCrewCount();

            System.out.println(String.format("%s build new colony at %s" + System.lineSeparator(), shipname, destinationName));
            ((Planet) engine.getSpaceObject().get(destination)).setPopulation(population);
            new LostShipCommand(factory, engine).executeCall(shipId, destination);
        } else {
            System.out.println(String.format("%s Probe arrived at %s" + System.lineSeparator(), shipname, destinationName));
            new LostShipCommand(factory, engine).executeCall(shipId, destination);
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

    private int lostShips() {
        int counterLostShip = 0;
        for (Ship ship : engine.getShip()) {
            if (ship instanceof LostShip) {
                counterLostShip++;
            }
        }
        return counterLostShip;
    }

    private void extinction() {
        int yearsBeforeAfterExtinction = Constants.YEAR_EXTINCTION_LEVEL_EVENT - Constants.YEAR;

        if (yearsBeforeAfterExtinction <= 0 && Constants.LOADCOUNTER > 0) {
            for (SpaceObject spaceObject : engine.getSpaceObject()) {
                if (spaceObject instanceof Planet && ((Planet) spaceObject).getObjectName().equals("Earth")) {
                    ((Planet) spaceObject).setPopulation(0);
                }
            }
        }
    }

    private String printReport() {
        int yearsBeforeAfterExtinction = Constants.YEAR_EXTINCTION_LEVEL_EVENT - Constants.YEAR;

        int totalShips = engine.getShip().size();
        int activeShips = totalShips - lostShips();

        String BeforeAfterExtinction = yearsBeforeAfterExtinction > 0 ? "before" : "after";
        yearsBeforeAfterExtinction = Math.abs(yearsBeforeAfterExtinction);
        String singleOrPlural = yearsBeforeAfterExtinction <= 1 ? "%d year " : "%d years ";
        String numberOfyearsBeforeAfter = yearsBeforeAfterExtinction == 0 ? "extinction Level Event" : String.format((singleOrPlural + BeforeAfterExtinction + " extinction Level Event"), yearsBeforeAfterExtinction);

        return String.format(
                "Year: %d" + System.lineSeparator() +
                        numberOfyearsBeforeAfter + System.lineSeparator() +
                        "Known Space Objects   : %d" + System.lineSeparator() +
                        "Colonized planets     : %d" + System.lineSeparator() +
                        "Total Population      : %d" + System.lineSeparator() +
                        "**************************" + System.lineSeparator() +
                        "Total number of ships : %d" + System.lineSeparator() +
                        "   Active ships       : %d" + System.lineSeparator() +
                        "   Lost ships         : %d" + System.lineSeparator() +
                        "**************************" + System.lineSeparator(),
                Constants.YEAR, engine.getSpaceObject().size(), colonizedPlanets, totalPopulation, totalShips, activeShips, lostShips());
    }


}


