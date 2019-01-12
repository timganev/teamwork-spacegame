package spaceObjects;


import spaceObjects.contracts.SpaceObject;
import enums.HostStarType;
import static constants.Constants.*;




public abstract class SpaceObjectBase implements SpaceObject {
    public static final String DISTANCE_ERROR_MASSAGE = "Distance should not be negative";
    public static final String OBJECT_NAME_ERROR_MASSAGE = String.format("Object name can not be less then %d or more then %d characters", MIN_OBJECT_NAME_LENGTH, MAX_OBJECT_NAME_LENGTH);
    public static final String STAR_NAME_ERROR_MASSAGE = String.format("Star name can not be less then %d or more then %d characters", MIN_STAR_NAME_LENGTH, MAX_STAR_NAME_LENGTH);


    private String objectName;
    private String hostStarName;
    private HostStarType hostStarType;
    private double distanceLightYears;


    public SpaceObjectBase(String objectName, String hostStarName, HostStarType hostStarType, double distanceLightYears) {
        setObjectName(objectName);
        setHostStarName(hostStarName);
        setHostStarType(hostStarType);
        setDistanceLightYears(distanceLightYears);
    }


    @Override
    public String getObjectName() {
        return objectName;
    }

    @Override
    public String getHostStarName() {
        return hostStarName;
    }

    @Override
    public HostStarType getHostStarType() {
        return this.hostStarType;
    }

    @Override
    public double getDistanceLightYears() {
        return distanceLightYears;
    }

    public abstract String printClassName();

    protected String printDetails() {
        return String.format(
                "Name: %s" + System.lineSeparator() +
                        "Host Star Name: %s" + System.lineSeparator() +
                        "Host Star type: %s" + System.lineSeparator() +
                        "Distance: %.2f light-years from Earth" + System.lineSeparator(),
                getObjectName(), getHostStarName(), getHostStarType(), getDistanceLightYears());
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(printClassName());
        sb.append(System.lineSeparator());
        sb.append(printDetails());
        return sb.toString();
    }

    public String toString() {
        return print();
    }

    private void setObjectName(String objectName) {
        if (objectName.length() < MIN_OBJECT_NAME_LENGTH || objectName.length() > MAX_OBJECT_NAME_LENGTH) {
            throw new IllegalArgumentException(OBJECT_NAME_ERROR_MASSAGE);
        }
        this.objectName = objectName;
    }

    private void setHostStarName(String hostStarName) {
        if (hostStarName.length() < MIN_STAR_NAME_LENGTH || hostStarName.length() > MAX_STAR_NAME_LENGTH) {
            throw new IllegalArgumentException(STAR_NAME_ERROR_MASSAGE);
        }
        this.hostStarName = hostStarName;
    }

    private void setHostStarType(HostStarType hostStarType) {
        this.hostStarType = hostStarType;
    }

    private void setDistanceLightYears(double distanceLightYears) {
        if (distanceLightYears < 0) {
            throw new IllegalArgumentException(DISTANCE_ERROR_MASSAGE);
        }
        this.distanceLightYears = distanceLightYears;
    }


}


