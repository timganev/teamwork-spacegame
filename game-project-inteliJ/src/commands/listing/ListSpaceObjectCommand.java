package commands.listing;

import spaceObjects.contracts.SpaceObject;
import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;

import java.util.ArrayList;
import java.util.List;


public class ListSpaceObjectCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public ListSpaceObjectCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        List<SpaceObject> celestialBodies = engine.getSpaceObject();
        if (celestialBodies.size() == 0) {
            return "There are no known space objects.";
        }

        List<String> listCelestialBodies = new ArrayList<>();
        for (SpaceObject celestialBody : celestialBodies) {
            listCelestialBodies.add(celestialBody.toString());
        }

        return String.join( System.lineSeparator(), listCelestialBodies).trim();
    }
}
