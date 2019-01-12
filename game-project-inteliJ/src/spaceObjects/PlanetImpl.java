package spaceObjects;

import spaceObjects.contracts.Planet;
import enums.HostStarType;
import static constants.Constants.*;

public class PlanetImpl extends SpaceObjectBase implements Planet {
    private static final String OBJECT_TEMPERATURE_ERROR_MASAGR = String.format("Object temperature can not be less then %.2f or more then %.2f", MIN_TEMPERATURE_FOR_LIFE , MAX_TEMPERATURE_FOR_LIFE);
    private final static String CLASS_NAME_PRINT = "Planet";
    private static final String OBJECT_RADIUS_ERROR_MASAGE = String.format("Object radius can not be negative or more then %.2f",MAX_FRACTION_OF_EARTH_RADIUS);
    private static final String OBJECT_MASS_ERROR_MASAGE = String.format("Object mass can not be negative or more then %.2f", MAX_FRACTION_OF_EARTH_MASS);
    private static final String MIN_PERIOD_ERROR_MASAGE = String.format("period can not be less then %.2f", MIN_PERIOD);

    private double massEarthM;
    private double radiusEarthR;
    private double tempC;
    private double periodDays;
    private long population = 0;
    private double populationGrowRate = BASE_POPULATION_GROW_RATE;

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
    public double getPopulationGrowRate() {
        return this.populationGrowRate;
    }

    @Override
    public String toString() {
        return print();
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setPopulationGrowRate(double populationGrowRate) {
        this.populationGrowRate = populationGrowRate;
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
                        "Planet radius: %.2f km" + System.lineSeparator() +
                        "Тemperature of the planet: %.2fC" + System.lineSeparator() +
                        "The days in one YEAR: %.2f" + System.lineSeparator() +
                        "Population: %d" + System.lineSeparator() +
                        "********************",
                getMassEarthM(), getRadiusEarthR(), getTempC(), getPeriodDays(), getPopulation()));

        return sb.toString();
    }


    private void setMassEarthM(double massEarthM) {
        if (massEarthM < 0 || massEarthM > MAX_FRACTION_OF_EARTH_MASS) {
            throw new IllegalArgumentException(OBJECT_MASS_ERROR_MASAGE);
        }
        this.massEarthM = massEarthM * EARTH_MASS;
    }

    private void setRadiusEarthR(double radiusEarthR) {
        if (radiusEarthR < 0 || radiusEarthR > MAX_FRACTION_OF_EARTH_RADIUS) {
            throw new IllegalArgumentException(OBJECT_RADIUS_ERROR_MASAGE);
        }
        this.radiusEarthR = radiusEarthR * EARTH_RADIUS;
    }

    private void setTempC(double tempC) {
        if (tempC < MIN_TEMPERATURE_FOR_LIFE || tempC > MAX_TEMPERATURE_FOR_LIFE) {
            throw new IllegalArgumentException(OBJECT_TEMPERATURE_ERROR_MASAGR);
        }
        this.tempC = tempC;
    }

    private void setPeriodDays(double periodDays) {
        if (periodDays < MIN_PERIOD) {
            throw new IllegalArgumentException(MIN_PERIOD_ERROR_MASAGE);
        }
        this.periodDays = periodDays;
    }

}

