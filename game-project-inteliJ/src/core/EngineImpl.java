package core;

import ships.shipContracts.Ship;
import spaceObjects.contracts.SpaceObject;
import commands.contracts.Command;
import core.contracts.*;
import core.factories.AgencyFactory;
import core.providers.*;


import java.util.ArrayList;
import java.util.List;

public class EngineImpl implements Engine {
    private static final String TERMINATION_COMMAND = "Exit";

    private Reader reader;
    private Writer writer;
    private Parser parser;

    private final List<SpaceObject> spaceObjects;
    private final List<Ship> ships;

    public EngineImpl(AgencyFactory factory) {
        reader = new ConsoleReader();
        writer = new ConsoleWriter();
        parser = new CommandParser(factory, this);

        spaceObjects = new ArrayList<>();
        ships = new ArrayList<>();
    }

    @Override
    public List<SpaceObject> getSpaceObject() {
        return spaceObjects;
    }

    @Override
    public List<Ship> getShip() {
        return ships;
    }

    @Override
    public void start() {
        while (true) {
            try {
                String commandAsString = reader.readLine();
                if (commandAsString.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    break;
                }
                processCommand(commandAsString);
            } catch (Exception ex) {
                writer.writeLine(ex.getMessage() != null && !ex.getMessage().isEmpty() ? ex.getMessage() : ex.toString());
                //writer.writeLine("####################");
            }
        }
    }


    private void processCommand(String commandAsString) {
        if (commandAsString == null || commandAsString.trim().equals("")) {
            throw new IllegalArgumentException("Command cannot be null or empty.");
        }
        Command command = parser.parseCommand(commandAsString);
        List<String> parameters = parser.parseParameters(commandAsString);
        String executionResult = command.execute(parameters);
        writer.writeLine(executionResult);
        //writer.writeLine("####################");
    }
}
