package commands.creation;

import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;
import spaceObjects.contracts.Planet;
import java.util.List;
import static constants.Constants.FAILED_TO_PARSE_MASSAGE;

public class CreatePlanetCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public CreatePlanetCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        String objectName;
        String hostStarName;
        String hostStarType;
        double massEarthM;
        double radiusEarthR;
        double tempC;
        double periodDays;
        double distanceLightYears;
        int population;
        try {
            objectName = parameters.get(0);
            hostStarName = parameters.get(1);
            hostStarType = parameters.get(2);
            massEarthM = Double.parseDouble(parameters.get(3));
            radiusEarthR = Double.parseDouble(parameters.get(4));
            tempC = Double.parseDouble(parameters.get(5));
            periodDays = Double.parseDouble(parameters.get(6));
            distanceLightYears = Double.parseDouble(parameters.get(7));

        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_MASSAGE + System.lineSeparator());
        }

        Planet planet = factory.createPlanet(objectName, hostStarName, hostStarType, distanceLightYears, massEarthM, radiusEarthR, tempC, periodDays);
        engine.getSpaceObject().add(planet);


        return String.format("Planet with ID %d was created." + System.lineSeparator(), engine.getSpaceObject().size());
    }

}

