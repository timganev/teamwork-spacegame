package commands.creation;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import constants.Constants;
import spaceObjects.contracts.AsteroidField;
import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import static constants.Constants.FAILED_TO_PARSE_MASSAGE;

public class CreateAsteroidFieldCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public CreateAsteroidFieldCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters){

        String objectName;
        String hostStarName ;
        String hostStarType ;
        boolean hasMetals = false;
        boolean hasRareEarthMinerals ;
        double distanceLightYears ;

        try {
            objectName = parameters.get(0);
            hostStarName = parameters.get(1);
            hostStarType = parameters.get(2);
            distanceLightYears = Double.parseDouble(parameters.get(3));
            hasMetals = Boolean.parseBoolean(parameters.get(4));
            hasRareEarthMinerals = Boolean.parseBoolean(parameters.get(5));
            ;

        } catch (Exception e) {
            throw new IllegalArgumentException(Constants.FAILED_TO_PARSE_MASSAGE);
        }

        AsteroidField asteroidField = factory.createAsteroidField(objectName, hostStarName, hostStarType, distanceLightYears, hasMetals, hasRareEarthMinerals);
        engine.getSpaceObject().add(asteroidField);

        return String.format("AsteroidField with ID %d was created." + System.lineSeparator(), engine.getSpaceObject().size());
    }

}

