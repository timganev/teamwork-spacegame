package spaceObjects;


import spaceObjects.contracts.SpaceObject;
import enums.HostStarType;


public abstract class SpaceObjectBase implements SpaceObject {
    private String objectName;
    private String hostStarName;
    private HostStarType hostStarType;
    private double distanceLightYears;
    private int objectID = 0;

//    @Override
//    public int getObjectID() {
//        return objectID;
//    }

    public SpaceObjectBase(String objectName, String hostStarName, HostStarType hostStarType, double distanceLightYears) {
        setObjectName(objectName);
        setHostStarName(hostStarName);
        setHostStarType(hostStarType);
        setDistanceLightYears(distanceLightYears);
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
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

    private void setObjectName(String objectName) {
        if (objectName.length() < 3 || objectName.length() > 20) {
            throw new IllegalArgumentException("Object name can not be less then 5 or more then 20 characters");
        }
        this.objectName = objectName;
    }

    private void setHostStarName(String hostStarName) {
        if (hostStarName.length() < 3 || hostStarName.length() > 20) {
            throw new IllegalArgumentException("Star name can not be less then 5 or more then 20 characters");
        }
        this.hostStarName = hostStarName;
    }

    private void setHostStarType(HostStarType hostStarType) {
        this.hostStarType = hostStarType;
    }


    private void setDistanceLightYears(double distanceLightYears) {
        if (distanceLightYears < 0) {
            throw new IllegalArgumentException("Distance should be more than 0");
        }
        this.distanceLightYears = distanceLightYears;
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
}


