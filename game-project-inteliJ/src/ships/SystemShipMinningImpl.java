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
        if (shipName == null || shipName.isEmpty() || shipName.matches("\\s+")) {
            super.shipName = "MinningShip";
        } else if (shipName.length() < Constants.MIN_SHIP_NAME_LENGTH || shipName.length() > Constants.MAX_SHIP_NAME_LENGTH ) {
            throw new IllegalArgumentException("Ship name cant be less than 2 or more than 15");
        } else {
            super.shipName = shipName;
        }
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


