package commands.creation;


import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.AgencyFactory;
import ships.shipContracts.Ship;

import java.util.List;

public class LostShipCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public LostShipCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        int shipId;
        String shipName;
        int destination;

        try {
            shipId = Integer.parseInt(parameters.get(0));

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse LostShip command parameters.");
        }

        shipName = engine.getShip().get(shipId).getShipName();
        destination = engine.getShip().get(shipId).getDestination();

        if ( GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear() > 0) {

            Ship ship = factory.createLostProbe(shipName, destination);
            engine.getShip().add(ship);
//            engine.getShip().get(shipId) = ship;
            return String.format("StarShipProbe with ID %d was created.", engine.getShip().size() - 1);
        } else {
            return String.format("Can not created new ships after Extinction Level Event in year %d.", GameBoard.getYearExtinctionLevelEvent());
        }


    }

}

