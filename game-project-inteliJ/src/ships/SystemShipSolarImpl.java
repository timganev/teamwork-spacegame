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
        super.setShipName(shipName);
    }

    @Override
    public String getType() {
        return "Solar ship";
    }

    public double getSunEnergy() {
        return this.sunEnergy;
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
