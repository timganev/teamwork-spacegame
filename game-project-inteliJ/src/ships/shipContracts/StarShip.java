package ships.shipContracts;

import enums.PropulsionType;

public interface StarShip extends Ship {

    public double getShipSpeed();

    public PropulsionType getPropulsion();
}
