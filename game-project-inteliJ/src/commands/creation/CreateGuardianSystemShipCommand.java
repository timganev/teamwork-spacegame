package commands.creation;

import commands.contracts.Command;
import constants.GameBoard;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.Ship;

import java.util.List;

public class CreateGuardianSystemShipCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public CreateGuardianSystemShipCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        String weapons;
        boolean crew;
        double shipMass;

        try {
            weapons = parameters.get(0);
            shipMass = Double.parseDouble(parameters.get(1));
            crew = Boolean.parseBoolean(parameters.get(2));



        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse GuardianShip command parameters.");
        }

        if (GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear() > 0) {
            Ship ship = factory.createSystemShipGuardian(weapons, crew, shipMass);
            engine.getShip().add(ship);
            return String.format("Guardian ship with ID %d was created.", engine.getShip().size());
        } else {
            return String.format("Can not created new ships after Extinction Level Event in year %d.", GameBoard.getYearExtinctionLevelEvent());
        }


    }

}
