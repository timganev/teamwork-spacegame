package commands.creation;

import commands.contracts.Command;
import constants.Constants;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.Ship;
import java.util.List;
import static constants.Constants.FAILED_TO_PARSE_MASSAGE;

public class CreateProbeStarShipCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public CreateProbeStarShipCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        String propulsion;
        String shipName;
        double shipMass;

        try {
            propulsion = parameters.get(0);
            shipName = parameters.get(1);
            shipMass = Double.parseDouble(parameters.get(2));


        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_MASSAGE + System.lineSeparator());
        }

        if (Constants.YEAR_EXTINCTION_LEVEL_EVENT - Constants.YEAR > 0) {
            Ship ship = factory.createStarShipProbe(propulsion, shipName, shipMass);
            engine.getShip().add(ship);
            return String.format("StarShipProbe with ID %d was created." + System.lineSeparator(), engine.getShip().size());
        } else {
            return String.format("Can not created new ships after Extinction Level Event in YEAR %d." + System.lineSeparator(), Constants.YEAR_EXTINCTION_LEVEL_EVENT);
        }

    }

}

