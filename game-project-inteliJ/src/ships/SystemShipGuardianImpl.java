package ships;

import constants.Constants;
import enums.WeaponsType;
import ships.shipContracts.SystemShipGuardian;

public class SystemShipGuardianImpl extends SystemShipBase implements SystemShipGuardian {

    private WeaponsType weapons;

    public SystemShipGuardianImpl(WeaponsType weapons, boolean crew, double shipMass) {
        super( crew, shipMass);
        setWeapons(weapons);

    }

    public WeaponsType getWeapons() {
        return this.weapons;
    }

    public void setWeapons(WeaponsType weapons) {
        if (isCrew()) {
            if (getCountOfCrew() < Constants.MAX_CREW_FOR_GUARDIAN_SHIP_WITH_LASERS) {
                this.weapons = WeaponsType.LASERS;
            } else {
                this.weapons = WeaponsType.ROCKETS;
            }
        } else {
            this.weapons = WeaponsType.ROCKETS_AND_LASERS;
        }
    }


    @Override
    public void next(int years) {}



    @Override
    public void setShipName(String shipName) {
        super.shipName = "Guardian";
    }

    @Override
    public String getType() {
        return "Guardian ship";
    }

    @Override
    public String toString() {
       return String.format(super.toString() +
               "WeaponsType:  %s" + System.lineSeparator(), getWeapons().toString());
    }

}
