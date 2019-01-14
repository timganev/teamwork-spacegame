package ships;

import constants.Constants;
import ships.shipContracts.SystemShipMinning;

public class SystemShipMinningImpl extends SystemShipBase implements SystemShipMinning {

    private double minerals;
    private double iron;


    public SystemShipMinningImpl(String shipName, double shipMass, boolean crew) {
        super(shipName, shipMass, crew);
    }

    @Override
    public void setShipName(String shipName) {
        super.setShipName(shipName);
    }

    @Override
    public String getType() {
        return "Mining ship";
    }

    @Override
    public double getMinerals() {
        return this.minerals;
    }

    @Override
    public double getIron() {
        return this.iron;
    }


    @Override
    public void next(int years) {
        this.iron = this.iron + (Constants.IRON_FOR_A_YEAR_FROM_MINNING_SHIP * years);
        this.minerals = this.minerals + (Constants.MINERALS_FOR_A_YEAR_FROM_MINNING_SHIP * years);
    }

    @Override
    public String toString() {
        return String.format(super.toString() +
                "Available minerals %.2f tons" + System.lineSeparator() +
                "Available iron %.2f tons" + System.lineSeparator(), getMinerals(), getIron());
    }
}


