package commands.creation;


import commands.contracts.Command;
import core.contracts.Engine;;
import core.factories.Factory;
import ships.shipContracts.Ship;
import ships.shipContracts.StarShipColonial;
import spaceObjects.contracts.Planet;

import java.util.List;

public class LostShipCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public LostShipCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        int shipId;
        String shipName;
        double shipMass;

        try {
            shipId = Integer.parseInt(parameters.get(0)) - 1;

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse LostShip command parameters." + System.lineSeparator());
        }

        shipName = engine.getShip().get(shipId).getShipName();

        shipMass = engine.getShip().get(shipId).getShipMass();

        Ship ship = factory.createLostShip(shipName, shipMass);
        engine.getShip().set(shipId, ship);

        return String.format("Ship with ID %d was lost." + System.lineSeparator(), shipId + 1);

    }

    public void executeCall(int shipId, int destination) {


        String shipName;
        double shipMass;


        shipName = engine.getShip().get(shipId).getShipName();
        shipMass = engine.getShip().get(shipId).getShipMass();

        if (engine.getShip().get(shipId) instanceof StarShipColonial) {
            Ship ship = factory.createLostShip(shipName, shipMass);
            engine.getShip().set(shipId, ship);
        } else {
            if (engine.getSpaceObject().get(destination) instanceof Planet) {
                Ship ship = factory.createSystemShipSolar(shipName, shipMass, false);
                engine.getShip().set(shipId, ship);
            } else {
                Ship ship = factory.createSystemShipMinning(shipName, shipMass, false);
                engine.getShip().set(shipId, ship);
            }
        }


    }

}

