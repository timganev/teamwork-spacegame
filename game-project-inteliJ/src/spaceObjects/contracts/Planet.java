package spaceObjects.contracts;

public interface Planet extends SpaceObject {

    double getMassEarthM();

    double getRadiusEarthR();

    double getTempC();

    double getPeriodDays();

    int getPopulation();

    void setPopulation(int population);

}
