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

    @Override
    public void next(int years) {
        this.gas = this.gas + (Constants.GAS_FOR_A_YEAR_FROM_PROBE * years);
        this.darkMatter = this.darkMatter + (Constants.DARK_MATTER_FOR_A_YEAR_FROM_PROBE * years);
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

    private double getGas() {
        return this.gas;
    }

    private double getDarkMatter() {
        return this.darkMatter;
    }
}
