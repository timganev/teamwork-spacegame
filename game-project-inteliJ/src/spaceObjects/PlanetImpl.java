package spaceObjects;

import constants.Constants;
import spaceObjects.contracts.Planet;
import enums.HostStarType;
//import celestial.HostStarType;

public class PlanetImpl extends SpaceObjectBase implements Planet {
    private final static String CLASS_NAME_PRINT = "Planet :";
    private double massEarthM;
    private double radiusEarthR;
    private double tempC;
    private double periodDays;
    private int population;

    public PlanetImpl(String objectName, String hostStarName, HostStarType hostStarType, double distanceLightYears, double massEarthM, double radiusEarthR, double tempC, double periodDays, int population) {
        super(objectName, hostStarName, hostStarType, distanceLightYears);
        setMassEarthM(massEarthM);
        setRadiusEarthR(radiusEarthR);
        setTempC(tempC);
        setPeriodDays(periodDays);
        this.population = population;
    }


    @Override
    public double getMassEarthM() {
        return massEarthM;
    }

    @Override
    public double getRadiusEarthR() {
        return radiusEarthR;
    }

    @Override
    public double getTempC() {
        return tempC;
    }

    @Override
    public double getPeriodDays() {
        return periodDays;
    }

    @Override
    public int getPopulation() {
        return this.population;
    }


    @Override
    public String toString() {
        return print();
    }


    private void setMassEarthM(double massEarthM) {
        if (massEarthM < 0 || massEarthM > Constants.MAX_FRACTION_OF_EARTH_MASS) {
            throw new IllegalArgumentException("Object mass can not be negative");
        }
        this.massEarthM = massEarthM * Constants.EARTH_MASS;
    }

    private void setRadiusEarthR(double radiusEarthR) {
        if (radiusEarthR < 0 || radiusEarthR > Constants.MAX_FRACTION_OF_EARTH_RADIUS) {
            throw new IllegalArgumentException("Object radius can not be negative or more then 10");
        }
        this.radiusEarthR = radiusEarthR * Constants.EARTH_RADIUS;
    }

    private void setTempC(double tempC) {
        if (tempC < Constants.MIN_TEMPERATURE_FOR_LIFE || tempC > Constants.MAX_TEMPERATURE_FOR_LIFE) {
            throw new IllegalArgumentException("Object temperature can not be less then -100 or more then 50");
        }
        this.tempC = tempC;
    }

    private void setPeriodDays(double periodDays) {
        if (periodDays < 1) {
            throw new IllegalArgumentException("period can not be less then 1");
        }
        this.periodDays = periodDays;
    }

    private void setPopulation(int population) {
        this.population += population;
    }




    @Override
    public String printClassName() {
        return CLASS_NAME_PRINT;
    }

    @Override
    public String printDetails() {
        StringBuilder sb = new StringBuilder(super.printDetails());
        sb.append(String.format(
                "Planet mass: %.4fx10^24 kg" + System.lineSeparator() +
                        "Planet radius: %.3f km" + System.lineSeparator() +
                        "Тemperature of the planet %.2fC: " + System.lineSeparator() +
                        "The days in one year: %.2f" + System.lineSeparator() +
                        "Population: %d" + System.lineSeparator() +
                        "********************",
                getMassEarthM(), getRadiusEarthR(), getTempC(), getPeriodDays(), getPopulation()));

        return sb.toString();
    }
}

