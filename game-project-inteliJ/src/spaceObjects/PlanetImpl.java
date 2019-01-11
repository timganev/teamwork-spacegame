package spaceObjects;

import spaceObjects.contracts.Planet;
import enums.HostStarType;

public class PlanetImpl extends SpaceObjectBase implements Planet {
    private final static String CLASS_NAME_PRINT = "Planet";
    private double massEarthM;
    private double radiusEarthR;
    private double tempC;
    private double periodDays;
    private long population = 0;

    public PlanetImpl(String objectName, String hostStarName, HostStarType hostStarType, double distanceLightYears, double massEarthM, double radiusEarthR, double tempC, double periodDays) {
        super(objectName, hostStarName, hostStarType, distanceLightYears);
        setMassEarthM(massEarthM);
        setRadiusEarthR(radiusEarthR);
        setTempC(tempC);
        setPeriodDays(periodDays);

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
    public long getPopulation() {
        return this.population;
    }


    @Override
    public String toString() {
        return print();
    }


    private void setMassEarthM(double massEarthM) {
        if (massEarthM < 0 || massEarthM > 5) {
            throw new IllegalArgumentException("Object mass can not be negative");
        }
        this.massEarthM = massEarthM * 5.9736;
    }

    private void setRadiusEarthR(double radiusEarthR) {
        if (radiusEarthR < 0 || radiusEarthR > 10) {
            throw new IllegalArgumentException("Object radius can not be negative or more then 10");
        }
        this.radiusEarthR = radiusEarthR * 6378.135;
    }

    private void setTempC(double tempC) {
        if (tempC < -100 || tempC > 60) {
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

    public void setPopulation(long population) {
        this.population = population;
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

