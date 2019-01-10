package commands.listing;

import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.LostShip;
import ships.shipContracts.Ship;

import java.util.ArrayList;
import java.util.List;

public class ListActiveShips implements Command  {

    private final Factory factory;
    private final Engine engine;

    public ListActiveShips(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        List<Ship> ships = engine.getShip();
        if (ships.size() == 0) {
            return "There aren't any ships.";
        }

        List<String> listActiveShips = new ArrayList<>();
        for (Ship ship : ships) {
            if (!(ship instanceof LostShip)) {
                listActiveShips.add(ship.toString());
            }
        }

        return String.join(System.lineSeparator(), listActiveShips).trim();
    }
}
