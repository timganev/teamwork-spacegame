package ships;

import constants.Constants;
import enums.WeaponsType;
import ships.shipContracts.SystemShipGuardian;

public class SystemShipGuardianImpl extends SystemShipBase implements SystemShipGuardian {

    private WeaponsType weapons;
    private boolean crew;

    public SystemShipGuardianImpl(WeaponsType weapons, boolean crew, double shipMass) {
        super(shipMass, crew);
        this.weapons = weapons;
        this.crew = crew;
    }


    @Override
    public String getShipName() {
        return shipName;
    }

    @Override
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }


    public WeaponsType getWeapons() {
        return this.weapons;
    }


    public void setWeapons(WeaponsType weapons) {

        this.weapons = WeaponsType.ROCKETS;

    }


    @Override
    public void next(int years) {
    }

    @Override
    public String getType() {
        return "Guardian ship";
    }

    @Override
    public String toString() {
        return String.format(super.toString() +
                "Weapons: %s" + System.lineSeparator(), getWeapons().toString()
        );
    }

}
