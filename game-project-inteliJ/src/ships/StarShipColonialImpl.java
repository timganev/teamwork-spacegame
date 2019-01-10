package ships;

import constants.Constants;
import enums.PropulsionType;
import ships.shipContracts.StarShipColonial;

public class StarShipColonialImpl extends StarShipBase implements StarShipColonial {

    private int crewCount;

    public StarShipColonialImpl(PropulsionType propulsion, String shipName, int crewCount, double shipMass) {
        super(propulsion, shipName, shipMass);
        setCrewCount(crewCount);
    }

    @Override
    public void setShipName(String shipName) {

        if (shipName == null || shipName.isEmpty() || shipName.matches("\\s+")) {
            super.shipName = getPropulsion().toString();
        } else if (shipName.length() < Constants.MIN_SHIP_NAME_LENGTH || shipName.length() > Constants.MAX_SHIP_NAME_LENGTH) {
            throw new IllegalArgumentException("Ship name should be more than 2 and less than 15");
        } else {
            super.shipName = shipName;
        }
    }

    @Override
    public String getType() {
        return "Colonial ship";
    }

    public int getCrewCount() {
        return this.crewCount;
    }

    public void setCrewCount(int crewCount) {
        if (crewCount < Constants.MIN_CREW_OF_COLONIAL_SHIP) {
            throw new IllegalArgumentException("Crew should be min 1000 persons");
        }
        this.crewCount = crewCount;
    }

    @Override
    public void next() {}

    @Override
    public void next(int years) {}

    @Override
    public String toString() {
        return String.format(super.toString() +
                "With crew number: %d" + System.lineSeparator(), getCrewCount()
        );
    }

}
