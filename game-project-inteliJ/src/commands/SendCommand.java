package commands;

import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.AgencyFactory;
import ships.StarShipBase;
import ships.StarShipProbeImpl;
import ships.shipContracts.StarShipColonial;
import spaceObjects.contracts.Planet;
import spaceObjects.contracts.SpaceObject;

import java.util.List;


public class SendCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public SendCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;

    }


    public String execute(List<String> parameters) {
        int shipID;
        int spaceObjectID;
        int turnsToDestination;



        try {
            shipID = Integer.parseInt(parameters.get(0));
            spaceObjectID = Integer.parseInt(parameters.get(1));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to pr");
        }


        if (engine.getShip().get(shipID) instanceof StarShipBase) {

            turnsToDestination = (int) (engine.getSpaceObject().get(spaceObjectID).getDistanceLightYears() / ((StarShipBase) engine.getShip().get(shipID)).getShipSpeed());
            ((StarShipBase) engine.getShip().get(shipID)).setTurnsToDestination(turnsToDestination);

            return String.format(
                    "Send %s %s with ID %d to" + System.lineSeparator() +
                            "%s" + System.lineSeparator() +
                            "The trip will take %d years",
                    ((StarShipBase) engine.getShip().get(shipID)).getPropulsion(),
                    ((StarShipBase) engine.getShip().get(shipID)).getType(),
                    shipID,
                    engine.getSpaceObject().get(spaceObjectID),
                    turnsToDestination);
        } else {
            return String.format("The ship has no propulsion");
        }


    }


}


