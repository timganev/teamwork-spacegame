package commands.creation;

//import celestial.enums.HostStarType;
import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.AgencyFactory;
import spaceObjects.contracts.Planet;

import java.util.List;

public class CreatePlanetCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreatePlanetCommand(AgencyFactory factory, Engine engine) {
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
            population = Integer.parseInt(parameters.get(8));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse CreatePlanet command parameters.");
        }

        Planet planet = factory.createPlanet(objectName, hostStarName, hostStarType, distanceLightYears, massEarthM, radiusEarthR, tempC, periodDays, population);
        engine.getSpaceObject().add(planet);



        return String.format("Planet with ID %d was created.", engine.getSpaceObject().size() - 1);
    }

}

