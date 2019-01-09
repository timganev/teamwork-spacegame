package ships;

import constants.Constants;
import ships.shipContracts.SystemShip;

public abstract class SystemShipBase extends ShipBase implements SystemShip {

    private boolean crew;
    private int countOfCrew;

    public SystemShipBase(String shipName, double shipMass, boolean crew) {
        super(shipName, shipMass);
        setCrew(crew);
    }
    public SystemShipBase(double shipMass, boolean crew, int countOfCrew) {
        super();
        setShipMass(shipMass);
        setCrew(crew);
        setCountOfCrew(countOfCrew);
    }

    public SystemShipBase(boolean crew, double shipMass) {
    }

    @Override
    public int getCountOfCrew() {
        return this.countOfCrew;
    }

    public void setCountOfCrew(int countOfCrew) {
        if (this.crew) {
            this.countOfCrew = countOfCrew;
        } else {
            throw new IllegalArgumentException("You don't have crew!");
        }
    }

    @Override
    public abstract void setShipName(String shipName);

    @Override
    public double getShipSpeed() {
        return Constants.SPEED_OF_SYSTEM_SHIP;
    }

    public boolean isCrew() {
        return this.crew;
    }

    public void setCrew(boolean crew) {
        this.crew = crew;
    }

    public String crewToString() {
        if (!this.crew) {
            return "Without crew";
        } else {
            return "With crew";
        }
    }

    @Override
    public String toString() {
        if (this.crew) {
            return   String.format(super.toString() +
                            "Crew: %s - %d people" + System.lineSeparator(), crewToString(), getCountOfCrew());
        } else {
            return String.format(super.toString() +
                    "Crew: %s" + System.lineSeparator(), crewToString());
        }
    }

}
