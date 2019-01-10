package spaceObjects.contracts;


import enums.HostStarType;

public interface SpaceObject {

    String getObjectName();

    String getHostStarName();

    HostStarType getHostStarType();

    double getDistanceLightYears();


}

