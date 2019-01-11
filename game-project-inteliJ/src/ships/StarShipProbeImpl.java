package ships;

import constants.Constants;
import enums.PropulsionType;
import ships.shipContracts.StarShipProbe;

public class StarShipProbeImpl extends StarShipBase implements StarShipProbe {
    private double gas;
    private double darkMatter;

    public StarShipProbeImpl(PropulsionType propulsion, String shipName, double shipMass) {
        super(propulsion, shipName, shipMass);
    }

    public double getGas() {
        return this.gas;
    }

    public double getDarkMatter() {
        return this.darkMatter;
    }


    @Override
    public void next(int years) {
        this.gas = this.gas + (Constants.GAS_FOR_A_YEAR_FROM_PROBE * years);
        this.darkMatter = this.darkMatter + (Constants.DARK_MATTER_FOR_A_YEAR_FROM_PROBE * years);
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
        return "Probe ship";
    }

    @Override
    public String toString() {
        return String.format(super.toString() +
                "Available gas: %.3f cubic meters" + System.lineSeparator() +
                "Available darkMatter: %.3f cubic centimetre "+ System.lineSeparator()
                ,getGas(), getDarkMatter()
        );
    }
}
