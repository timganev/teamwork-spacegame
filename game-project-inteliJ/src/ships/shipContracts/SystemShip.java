package ships.shipContracts;

public interface SystemShip extends Ship {

   int getCountOfCrew();

    double getShipSpeed();

    boolean isCrew();

    String crewToString();
}
