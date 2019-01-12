package spaceObjects.contracts;

public interface Planet extends SpaceObject {

    double getMassEarthM();

    double getRadiusEarthR();

    double getTempC();

    double getPeriodDays();

    long getPopulation();

    double getPopulationGrowRate();

    void setPopulationGrowRate(double populationGrowRate);

    void setPopulation(long population);

}
