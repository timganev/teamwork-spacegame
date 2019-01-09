package commands.creation;

import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.AgencyFactory;
import ships.shipContracts.Ship;

import java.util.List;

public class CreateMinningSystemShipCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateMinningSystemShipCommand(AgencyFactory factory, Engine engine) {
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
            throw new IllegalArgumentException("Failed to parse MinningShip command parameters.");
        }

        if (GameBoard.getYearExtinctionLevelEvent() - GameBoard.getYear() > 0) {
            Ship ship = factory.createSystemShipMinning(shipName, shipMass, crew);
            engine.getShip().add(ship);
            return String.format("Minning ship with ID %d was created.", engine.getShip().size() - 1);
        } else {
            return String.format("Can not created new ships after Extinction Level Event in year %d.", GameBoard.getYearExtinctionLevelEvent());
        }


    }

}
