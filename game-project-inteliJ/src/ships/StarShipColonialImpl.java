package ships;

import constants.Constants;
import enums.PropulsionType;
import ships.shipContracts.StarShipColonial;

public class StarShipColonialImpl extends StarShipBase implements StarShipColonial {

    private int crewCount;

    public StarShipColonialImpl(PropulsionType propulsion, String shipName, double shipMass, int crewCount) {
        super(propulsion, shipName, shipMass);
        setCrewCount(crewCount);
    }

    public String getShipName() {
        return super.shipName;
    }

    @Override
    public String getType() {
        return "Colonial ship";
    }

    public int getCrewCount() {
        return this.crewCount;
    }

    @Override
    public void next(int years) {}

    @Override
    public String toString() {
        return String.format(super.toString() +
                "With crew number: %d" + System.lineSeparator(), getCrewCount()
        );
    }

    private void setCrewCount(int crewCount) {
        if (crewCount < Constants.MIN_CREW_OF_COLONIAL_SHIP) {
            throw new IllegalArgumentException("Crew should be min 1000");
        }
        this.crewCount = crewCount;
    }

}
