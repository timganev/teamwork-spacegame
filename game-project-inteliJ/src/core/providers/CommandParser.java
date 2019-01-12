package core.providers;

import commands.HelpCommand;
import commands.NextCommand;
import commands.SendCommand;
import commands.contracts.Command;
import commands.creation.*;
import commands.listing.*;
import core.contracts.Engine;
import core.contracts.Parser;
import core.factories.Factory;

import java.util.ArrayList;
import java.util.List;

public class CommandParser implements Parser {
    private static final String INVALID_COMMAND = "Invalid command name: %s!";

    private final Factory factory;
    private final Engine engine;

    public CommandParser(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public Command parseCommand(String fullCommand) {
        String commandName = fullCommand.split(" ")[0];
        return findCommand(commandName);
    }

    public List<String> parseParameters(String fullCommand) {
        String[] commandParts = fullCommand.split(" ");
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 1; i < commandParts.length; i++) {
            parameters.add(commandParts[i]);
        }
        return parameters;
    }

    private Command findCommand(String commandName) {
        switch (commandName.toLowerCase()) {

            case "createasteroidfield":
                return new CreateAsteroidFieldCommand(factory, engine);

            case "createplanet":
                return new CreatePlanetCommand(factory, engine);

            case "createcolonialship":
                return new CreateColonialShipCommand(factory, engine);

            case "createstarshiprobe":
                return new CreateProbeStarShipCommand(factory, engine);

            case "createsystemshipguardian":
                return new CreateGuardianSystemShipCommand(factory, engine);

            case "createsystemshipminning":
                return new CreateMinningSystemShipCommand(factory, engine);

            case "createsystemshipsolar":
                return new CreateSolarSystemShipCommand(factory, engine);

            case "listobjects":
                return new ListSpaceObjectCommand(factory, engine);

            case "listships":
                return new ListShipCommand(factory, engine);

            case "help":
                return new HelpCommand(factory, engine);

            case "next":
                return new NextCommand(factory, engine);

            case "send":
                return new SendCommand(factory, engine);

            case "load":
                return new CreateUniverseCommand(factory, engine);

            case "lostship":
                return new LostAndRefactorShipCommand(factory, engine);

            case "listlostships":
                return new ListLostShipsCommand(factory, engine);

            case "listactiveships":
                return new ListActiveShips(factory, engine);

            case "listplanets":
                return new ListPlanets(factory, engine);

            case "listcolonial":
                return new ListColonyShips(factory, engine);
        }

        throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandName));
    }
}
