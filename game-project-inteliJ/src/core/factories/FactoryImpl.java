package core.factories;


import enums.PropulsionType;
import enums.WeaponsType;
import ships.*;
import ships.shipContracts.*;
import spaceObjects.AsteroidFieldImpl;
import spaceObjects.PlanetImpl;
import spaceObjects.contracts.AsteroidField;
import spaceObjects.contracts.Planet;
import enums.HostStarType;


public class FactoryImpl implements Factory {

    public FactoryImpl() {
    }

    @Override
    public Planet createPlanet(String objectName, String hostStarName, String hostStarType, double distanceLightYears, double massEarthM, double radiusEarthR, double tempC, double periodDays) {


        return new PlanetImpl(objectName, hostStarName, getHostStarType(hostStarType), distanceLightYears, massEarthM, radiusEarthR, tempC, periodDays);
    }

    @Override
    public AsteroidField createAsteroidField(String objectName, String hostStarName, String hostStarType, double distanceLightYears, boolean hasMetals, boolean hasRareEarthMinerals) {
        return new AsteroidFieldImpl(objectName, hostStarName, getHostStarType(hostStarType), distanceLightYears, hasMetals, hasRareEarthMinerals);
    }

    @Override
    public StarShipColonial createColonialShip(String propulsion, String shipName, int crew, double shipMass) {
        return new StarShipColonialImpl(getPropulsionType(propulsion), shipName, shipMass, crew);
    }

    public LostShip createLostShip(String shipName, double shipMass) {
        return new LostShipImpl(shipName, shipMass);
    }

    @Override
    public StarShipProbe createStarShipProbe(String propulsion, String shipName, double shipMass) {
        return new StarShipProbeImpl(getPropulsionType(propulsion), shipName, shipMass);
    }

    @Override
    public SystemShipGuardian createSystemShipGuardian(String weapons, boolean crew, double shipMass) {
        return new SystemShipGuardianImpl(getWeaponType(weapons), crew, shipMass);
    }

    @Override
    public SystemShipMinning createSystemShipMinning(String shipName, double shipMass, boolean crew) {
        return new SystemShipMinningImpl(shipName, shipMass, crew);
    }

    @Override
    public SystemShipSolar createSystemShipSolar(String shipName, double shipMass, boolean crew) {
        return new SystemShipSolarImpl(shipName, shipMass, crew);
    }


    private HostStarType getHostStarType(String hostStarType) {
        switch (hostStarType) {
            case "giant":
                return HostStarType.GIANT;
            case "blue":
                return HostStarType.BLUE;
            case "yellow":
                return HostStarType.YELLOW;
            case "white":
                return HostStarType.WHITE;
            default:
                throw new IllegalArgumentException(String.format("Invalid host star type: %s", hostStarType));
        }
    }

    private PropulsionType getPropulsionType(String propulsion) {
        switch (propulsion) {
            case "Sail":
                return PropulsionType.SAIL;
            case "Nukes":
                return PropulsionType.NUKES;
            case "Fusion engine":
                return PropulsionType.FUSION_ENGINE;
            case "Antimatter":
                return PropulsionType.ANTIMMATER;
            default:
                throw new IllegalArgumentException(String.format("Invalid propulsion type: %s", propulsion));
        }

    }

    private WeaponsType getWeaponType(String weapons) {
        switch (weapons) {
            case "Rocket":
                return WeaponsType.ROCKETS;
            case "Lasers":
                return WeaponsType.LASERS;
            case "Rocket and lasers":
                return WeaponsType.ROCKETS_AND_LASERS;
            default:
                throw new IllegalArgumentException(String.format("Does not exist weapon: %s", weapons));
        }

    }


}

