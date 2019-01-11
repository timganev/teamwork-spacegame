package commands.listing;

import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;
import ships.shipContracts.LostShip;
import ships.shipContracts.Ship;
import ships.shipContracts.StarShipColonial;

import java.util.ArrayList;
import java.util.List;

public class ListColonyShips implements Command  {

    private final Factory factory;
    private final Engine engine;

    public ListColonyShips(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {

        List<Ship> ships = engine.getShip();
        if (ships.size() == 0) {
            return "There aren't any ships.";
        }

        List<String> listColonialShip = new ArrayList<>();
        for (Ship ship : ships) {
            if (ship instanceof StarShipColonial) {
                listColonialShip.add(ship.toString());
            }
        }

        return String.join(System.lineSeparator(), listColonialShip).trim();
    }
}
