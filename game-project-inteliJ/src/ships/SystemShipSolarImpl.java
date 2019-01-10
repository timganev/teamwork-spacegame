package ships;

import constants.Constants;
import ships.shipContracts.SystemShipSolar;

public class SystemShipSolarImpl extends SystemShipBase implements SystemShipSolar {

    private double sunEnergy;

    public SystemShipSolarImpl(String shipName, double shipMass, boolean crew) {
        super(shipName, shipMass, crew);
    }



    @Override
    public void setShipName(String shipName) {
        if (shipName == null || shipName.isEmpty() || shipName.matches("\\s+")) {
            super.shipName = "SolarShip";
        } else if (shipName.length() < Constants.MIN_SHIP_NAME_LENGTH || shipName.length() > Constants.MAX_SHIP_NAME_LENGTH) {
            throw new IllegalArgumentException("Ship name cant be less than 2 or more than 15");
        } else {
            super.shipName = shipName;
        }
    }

    @Override
    public String getType() {
        return "Solar ship";
    }

    public double getSunEnergy() {
        return this.sunEnergy;
    }

    @Override
    public void next() {
        this.sunEnergy = this.sunEnergy + Constants.SUN_ENERGY_FOR_A_YEAR_FROM_SOLAR_SHIP;
    }

    @Override
    public void next(int years) {
        this.sunEnergy = this.sunEnergy + (Constants.SUN_ENERGY_FOR_A_YEAR_FROM_SOLAR_SHIP * years);
    }
    @Override
    public String toString() {
        return String.format(super.toString() +
                "Available sunenergy %.2f MW" + System.lineSeparator(),getSunEnergy());
    }
}
