package ships;

import commands.creation.LostShipCommand;
import commands.listing.ListLostShipsCommand;
import constants.Constants;
import ships.shipContracts.Ship;

public abstract class ShipBase implements Ship {
    private static int shipId = 0;
    protected String shipName;
    protected double shipMass;
    private int turnsToDestination;
    private int destination;

    public ShipBase(String shipName, double shipMass) {
        setShipName(shipName);
        setShipMass(shipMass);
        this.turnsToDestination = 0;
        this.destination = 0;
    }

    public ShipBase() {
    }

    public String getShipName() {
        return this.shipName;
    }

    public abstract void setShipName(String shipName);

    public abstract double getShipSpeed();

    @Override
    public int getDestination() {
        return destination;
    }

    @Override
    public int getTurnsToDestination() {
        return turnsToDestination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setTurnsToDestination(int turnsToDestination) {
        this.turnsToDestination = turnsToDestination;
    }

    @Override
    public double getShipMass() {
        return this.shipMass;
    }

    public void setShipMass(double shipMass) {
            if (shipMass < Constants.MIN_SHIP_MASS) {
                throw new IllegalArgumentException("Ship mass should be more than 5000");
            }
            this.shipMass = shipMass;
    }

    public abstract String getType();

    @Override
    public abstract void next();

    @Override
    public String toString() {
        return String.format(
                "Ship type: %s " + System.lineSeparator() +
                        "Ship name: %s" + System.lineSeparator() +
                        "Ship mass: %.2f " + System.lineSeparator() +
                        "Years to destination %d" + System.lineSeparator() +
                        "Destination ID %d" + System.lineSeparator(),
                getType(), getShipName(), getShipMass(), getTurnsToDestination(), getDestination()
        );
    }


}

