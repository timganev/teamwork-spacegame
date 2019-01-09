package commands.creation;

//import celestial.enums.HostStarType;

import commands.contracts.Command;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.AgencyFactory;
import ships.shipContracts.Ship;
import spaceObjects.contracts.AsteroidField;
import spaceObjects.contracts.Planet;

import java.util.List;

public class CreateUniverseCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateUniverseCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {
        if (GameBoard.loadCounter>0) {
            return String.format("Known universe was already loaded.");
        } else {
            GameBoard.loadCounter++;
            Planet earth = factory.createPlanet("Earth", "Sol", "yellow", 0, 1, 1, 15, 365.4, 6000000);
            Planet alfab = factory.createPlanet("AlfaB", "Alfa", "blue", 4, 0.9, 1.1, -25, 101, 0);

            AsteroidField solBelt = factory.createAsteroidField("Belt", "Sol", "yellow", 0, true, true);
            AsteroidField alfaBelt = factory.createAsteroidField("alfaBelt", "Alfa", "blue", 4, true, true);

            Ship ship = factory.createStarShipProbe("SAIL", "Dominator", 100000);
            engine.getShip().add(ship);

            engine.getSpaceObject().add(earth);
            engine.getSpaceObject().add(alfab);
            engine.getSpaceObject().add(solBelt);
            engine.getSpaceObject().add(alfaBelt);

            return String.format("Known universe was loaded.");
        }
    }

}

