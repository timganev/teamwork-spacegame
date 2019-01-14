package ships;


import ships.shipContracts.Ship;

import static constants.Constants.*;


public abstract class ShipBase implements Ship {
    private static final String SHIP_MASS_ERROR_MASSAGE = String.format("Ship mass should be more than %.2f", MIN_SHIP_MASS);
    private final String SHIP_NAME_ERROR_MASSAGE = String.format("Ship name should be more than %d and less than %d",MIN_SHIP_NAME_LENGTH, MAX_SHIP_NAME_LENGTH);
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


    public void setShipName(String shipName) {
        if (shipName.length() < MIN_SHIP_NAME_LENGTH || shipName.length() > MAX_SHIP_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(SHIP_NAME_ERROR_MASSAGE));
        } else {
            this.shipName = shipName;
        }
    }


    public abstract double getShipSpeed();

    @Override
    public int getDestination() {
        return destination;
    }

    @Override
    public int getTurnsToDestination() {
        return turnsToDestination;
    }

    @Override
    public double getShipMass() {
        return this.shipMass;
    }

    protected void setShipMass(double shipMass) {
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

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setTurnsToDestination(int turnsToDestination) {
        this.turnsToDestination = turnsToDestination;
    }
}

