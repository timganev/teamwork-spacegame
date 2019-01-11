package spaceObjects.contracts;

public interface Planet extends SpaceObject {

    double getMassEarthM();

    double getRadiusEarthR();

    double getTempC();

    double getPeriodDays();

    long getPopulation();

    void setPopulation(long population);

}
