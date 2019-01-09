package ships;

import constants.Constants;
import enums.PropulsionType;
import ships.shipContracts.StarShip;
import static core.GameBoard.lightSpeed;

public abstract class StarShipBase extends ShipBase implements StarShip {


    private PropulsionType propulsion;

    public StarShipBase(PropulsionType propulsion, String shipName, double shipMass) {
        super(shipName, shipMass);
        setPropulsion(propulsion);
    }

    public StarShipBase(String shipName) {
    }

    @Override
    public PropulsionType getPropulsion() {
        return this.propulsion;
    }

    public void setPropulsion(PropulsionType propulsion) {
        this.propulsion = propulsion;
    }

    @Override
    public abstract void setShipName(String shipName);

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
}
