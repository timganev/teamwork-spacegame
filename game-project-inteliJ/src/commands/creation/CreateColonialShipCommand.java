package commands.creation;


import commands.contracts.Command;
import constants.Constants;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.Ship;
import java.util.List;
import static constants.Constants.*;

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
            throw new IllegalArgumentException(String.format(FAILED_TO_PARSE_MASSAGE + System.lineSeparator()));
        }

        if (Constants.YEAR_EXTINCTION_LEVEL_EVENT - Constants.YEAR > 0) {
            if (Constants.YEAR >= YEAR_COLONIAL_SHIP_CAPABILITY && COLONIAL_SHIP_COUNT_DOWN > 0) {
                COLONIAL_SHIP_COUNT_DOWN--;
                COLONIAL_SHIP_COUNT_UP++;
                Ship ship = factory.createColonialShip(propulsion, shipName, crew, shipMass);
                engine.getShip().add(ship);
                return String.format("ColonialShip with ID %d was created. Humanity has resources for another %d"+ System.lineSeparator(), engine.getShip().size(), COLONIAL_SHIP_COUNT_DOWN);
            } else {
                return String.format("Can not created ColonialShip before develop Colonial Ship Capability in YEAR %d or more then %d Colonial Ships"+ System.lineSeparator(), YEAR_COLONIAL_SHIP_CAPABILITY, COLONIAL_SHIP_COUNT_UP+COLONIAL_SHIP_COUNT_DOWN);
            }
        } else {
            return String.format("Can not created new ships after Extinction Level Event in YEAR %d."+ System.lineSeparator(), Constants.YEAR_EXTINCTION_LEVEL_EVENT);
        }

    }

}

