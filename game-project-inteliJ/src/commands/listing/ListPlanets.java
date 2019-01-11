package commands.listing;

import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;
import spaceObjects.contracts.Planet;
import spaceObjects.contracts.SpaceObject;

import java.util.ArrayList;
import java.util.List;


public class ListPlanets implements Command {
    private final Factory factory;
    private final Engine engine;

    public ListPlanets(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {


        if (engine.getSpaceObject().size() == 0) {
            return "There are no known planets.";
        }

        List<String> planets = new ArrayList<>();
        for (SpaceObject spaceObject : engine.getSpaceObject()) {
            if (spaceObject instanceof Planet) {
                planets.add(
                        String.format("Object ID: %d" + System.lineSeparator(), engine.getSpaceObject().indexOf(spaceObject)) +
                                spaceObject.toString());
            }
        }

        return String.join( System.lineSeparator(), planets).trim();
    }
}
