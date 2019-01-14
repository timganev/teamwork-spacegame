package ships;

import constants.Constants;
import enums.PropulsionType;
import ships.shipContracts.StarShip;

public abstract class StarShipBase extends ShipBase implements StarShip {




    public StarShipBase(PropulsionType propulsion, String shipName, double shipMass) {
        super(shipName, shipMass);
        setPropulsion(propulsion);
    }

    public StarShipBase(String shipName) {
    }

    public void setShipName(String shipName) {

        if (shipName == null || shipName.isEmpty() || shipName.matches("\\s+")) {
            super.shipName = getPropulsion().toString();
        } else {
            super.setShipName(shipName);
        }
    }

    @Override
    public PropulsionType getPropulsion() {
        return this.propulsion;
    }

    private void setPropulsion(PropulsionType propulsion) {
        this.propulsion = propulsion;
    }


    @Override
    public double getShipSpeed() {

        switch (this.propulsion) {
            case SAIL: {
                return Constants.SPEED_OF_SAIL_ENGINE_FRACTION_OF_LIGHT_SPEED;
            }
            case NUKES: {
                return Constants.SPEED_OF_NUKES_ENGINE_FRACTION_OF_LIGHT_SPEED;
            }
            case FUSION_ENGINE: {
                return Constants.SPEED_OF_FUSION_ENGINE_ENGINE_FRACTION_OF_LIGHT_SPEED;
            }
            default: {
                return Constants.SPEED_OF_ANTIMMATER_ENGINE_FRACTION_OF_LIGHT_SPEED;
            }
        }
    }

    @Override
    public String toString() {
        return String.format(super.toString() +
                "Ship propulsion: %s" + System.lineSeparator(), getPropulsion().toString()
        );
    }

    private PropulsionType propulsion;
}
