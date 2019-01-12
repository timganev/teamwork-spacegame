package commands.creation;

import commands.contracts.Command;
import constants.Constants;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.Ship;

import java.util.List;

public class CreateSolarSystemShipCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public CreateSolarSystemShipCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        String shipName;
        double shipMass;
        boolean crew;


        try {
            shipName = parameters.get(0);
            shipMass = Double.parseDouble(parameters.get(1));
            crew = Boolean.parseBoolean(parameters.get(2));


        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse SolarShip command parameters."+System.lineSeparator());
        }

        if (Constants.YEAR_EXTINCTION_LEVEL_EVENT - Constants.YEAR > 0) {
            Ship ship = factory.createSystemShipSolar(shipName, shipMass, crew);
            engine.getShip().add(ship);

            return String.format("Solar ship with ID %d was created."+System.lineSeparator(), engine.getShip().size());
        } else {
            return String.format("Can not created new ships after Extinction Level Event in YEAR %d."+System.lineSeparator(), Constants.YEAR_EXTINCTION_LEVEL_EVENT);
        }

    }

}
