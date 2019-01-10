package commands.listing;

import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.Ship;

import java.util.ArrayList;
import java.util.List;


public class ListShipCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public ListShipCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        List<Ship> ships = engine.getShip();
        if (ships.size() == 0) {
            return "There aren't any ships.";
        }

        List<String> listShips = new ArrayList<>();
        for (Ship ship : ships) {
            listShips.add(
                    String.format("Ship ID: %d" + System.lineSeparator(),engine.getShip().indexOf(ship) + 1) +
                    ship.toString());
        }

        return String.join( System.lineSeparator(), listShips).trim();
    }
}
