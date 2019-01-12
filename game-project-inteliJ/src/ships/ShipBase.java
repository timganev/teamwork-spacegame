package ships;

import constants.Constants;
import ships.shipContracts.Ship;

import static constants.Constants.MIN_SHIP_MASS;

public abstract class ShipBase implements Ship {
    public static final String SHIP_MASS_ERROR_MASSAGE = String.format("Ship mass should be more than %.2f", MIN_SHIP_MASS);
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
            if (shipMass < MIN_SHIP_MASS) {
                throw new IllegalArgumentException(SHIP_MASS_ERROR_MASSAGE);
            }
            this.shipMass = shipMass;
    }

    public abstract String getType();


    @Override
    public String toString() {
        return String.format(
                "Ship type: %s" + System.lineSeparator() +
                        "Ship name: %s" + System.lineSeparator() +
                        "Ship mass: %.2f" + System.lineSeparator() +
                        "Years to destination %d" + System.lineSeparator() +
                        "Destination ID %d" + System.lineSeparator(),
                getType(), getShipName(), getShipMass(), getTurnsToDestination(), getDestination()
        );
    }


}

