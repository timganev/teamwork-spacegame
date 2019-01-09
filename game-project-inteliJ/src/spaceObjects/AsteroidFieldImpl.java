package spaceObjects;

import spaceObjects.contracts.AsteroidField;
import enums.HostStarType;

public class AsteroidFieldImpl extends SpaceObjectBase implements AsteroidField {
    private final static String CLASS_NAME_PRINT = "Asteroid Field :";
    private boolean hasMetals;
    private boolean hasRareEarthMinerals;


    public AsteroidFieldImpl(String objectName, String hostStarName, HostStarType hostStarType, double distanceLightYears, boolean hasMetals, boolean hasRareEarthMinerals) {
        super(objectName, hostStarName, hostStarType, distanceLightYears);
        this.hasMetals = hasMetals;
        this.hasRareEarthMinerals = hasRareEarthMinerals;

    }

    @Override
    public boolean hasMetals() {
        return hasMetals;
    }

    @Override
    public boolean hasRareEarthMinerals() {
        return hasRareEarthMinerals;
    }

    @Override
    public String printClassName() {
        return CLASS_NAME_PRINT;
    }

    @Override
    public String printDetails() {
        StringBuilder sb = new StringBuilder(super.printDetails());
        sb.append(String.format(
                        "Detected metals: %b" + System.lineSeparator() +
                        "Detected rare earth minerals: %b" + System.lineSeparator() +
                        "********************",
                hasMetals(), hasRareEarthMinerals()));

        return sb.toString();
    }

}


