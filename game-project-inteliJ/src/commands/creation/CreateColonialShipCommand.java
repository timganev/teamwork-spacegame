package commands.creation;


import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.Ship;

import java.util.List;

public class CreateColonialShipCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public CreateColonialShipCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        String propulsion;
        String shipName;
        int crew;
        double shipMass;

        try {
            propulsion = parameters.get(0);
            shipName = parameters.get(1);
            crew = Integer.parseInt(parameters.get(2));
            shipMass = Double.parseDouble(parameters.get(3));


        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse ColonialShip command parameters.");
        }

        if (GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear() > 0) {
            if (GameBoard.getYear() >= GameBoard.yearColonialShipCapability) {
                Ship ship = factory.createColonialShip(propulsion, shipName, crew, shipMass);
                engine.getShip().add(ship);
                return String.format("ColonialShip with ID %d was created.", engine.getShip().size());
            } else {
                return String.format("Can not created ColonialShip before develop  Colonial Ship Capability in year %d.", GameBoard.yearColonialShipCapability);
            }
        } else {
            return String.format("Can not created new ships after Extinction Level Event in year %d.", GameBoard.getYearExtinctionLevelEvent());
        }

    }

}

