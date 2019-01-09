package core.factories;

import enums.PropulsionType;
import ships.LostShipImpl;
import ships.shipContracts.*;
import spaceObjects.contracts.AsteroidField;
import spaceObjects.contracts.Planet;


public interface AgencyFactory {


    Planet createPlanet(String objectName, String hostStarName, String hostStarType, double distanceLightYears, double massEarthM, double radiusEarthR, double tempC, double periodDays, int population);

    AsteroidField createAsteroidField(String objectName, String hostStarName, String hostStarType, double distanceLightYears, boolean hasMetals, boolean hasRareEarthMinerals);

    StarShipColonial createColonialShip(String propulsion, String shipName, int crew, double shipMass);

    StarShipProbe createStarShipProbe(String propulsion, String shipName, double shipMass);

    SystemShipGuardian createSystemShipGuardian(String weapons, boolean crew, double shipMass);

    SystemShipMinning createSystemShipMinning(String shipName, double shipMass, boolean crew);

    SystemShipSolar createSystemShipSolar(String shipName, double shipMass, boolean crew);

    LostShipImpl createLostProbe(String shipName, int destination);
}
