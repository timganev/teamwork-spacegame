package commands.creation;


import spaceObjects.contracts.AsteroidField;
import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;

import java.util.List;

public class CreateAsteroidFieldCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public CreateAsteroidFieldCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        String objectName;
        String hostStarName;
        String hostStarType;
        boolean hasMetals;
        boolean hasRareEarthMinerals;
        double distanceLightYears;

        try {
            objectName = parameters.get(0);
            hostStarName = parameters.get(1);
            hostStarType = parameters.get(2);
            distanceLightYears = Double.parseDouble(parameters.get(3));
            hasMetals = Boolean.parseBoolean(parameters.get(4));
            hasRareEarthMinerals = Boolean.parseBoolean(parameters.get(5));;

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse AsteroidField command parameters.");
        }

        AsteroidField asteroidField = factory.createAsteroidField(objectName, hostStarName, hostStarType, distanceLightYears, hasMetals, hasRareEarthMinerals);
        engine.getSpaceObject().add(asteroidField);


        return String.format("AsteroidField with ID %d was created.", engine.getSpaceObject().size());
    }

}

