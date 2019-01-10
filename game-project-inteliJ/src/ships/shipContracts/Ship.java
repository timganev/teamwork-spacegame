package ships.shipContracts;

public interface Ship {


    String getShipName();

    double getShipMass();

    String toString();

    void next();

    void next(int years);

    int getTurnsToDestination();

    int getDestination();
}
