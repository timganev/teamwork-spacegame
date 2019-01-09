package commands.creation;

import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.AgencyFactory;
import ships.shipContracts.Ship;

import java.util.List;

public class CreateGuardianSystemShipCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateGuardianSystemShipCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        String weapons;
        boolean crew;
        double shipMass;

        try {
            weapons = parameters.get(0);
            crew = Boolean.parseBoolean(parameters.get(1));
            shipMass = Double.parseDouble(parameters.get(2));


        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse GuardianShip command parameters.");
        }

        if (GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear() > 0) {
            Ship ship = factory.createSystemShipGuardian(weapons, crew, shipMass);
            engine.getShip().add(ship);
            return String.format("Guardian ship with ID %d was created.", engine.getShip().size() - 1);
        } else {
            return String.format("Can not created new ships after Extinction Level Event in year %d.", GameBoard.getYearExtinctionLevelEvent());
        }


    }

}
