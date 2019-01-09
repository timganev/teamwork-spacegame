package ships.shipContracts;

public interface Ship {


    String getShipName();

    int getShipId();

    double getShipMass();

    String toString();

    void next();

    void next(int years);

    int getTurnsToDestination();

    int getDestination();
}
