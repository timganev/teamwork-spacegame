package core.contracts;



import ships.shipContracts.Ship;
import spaceObjects.contracts.SpaceObject;


import java.util.List;

public interface Engine {
    void start();

    List<SpaceObject> getSpaceObject();
    List<Ship> getShip();
}
