package ships;

import constants.GameBoard;
import ships.shipContracts.LostShip;


public class LostShipImpl extends ShipBase implements LostShip {


    private int yearLostShip;


    public LostShipImpl(String shipName, double shipMass) {
        super(shipName, shipMass);
        this.yearLostShip = GameBoard.getYear();
    }

    @Override
    public void setShipName(String shipName) {
        super.shipName = shipName;
    }

    @Override
    public double getShipSpeed() {
        return 0;
    }

    @Override
    public String getType() {
        return "Lost ship";
    }


    @Override
    public void next(int years) {}


    @Override
    public String toString() {
        return String.format(
                "Ship type: %s " + System.lineSeparator() +
                        "Ship name: %s" + System.lineSeparator() +
                        "Lost in year:  %d" + System.lineSeparator(), getType(), getShipName(),getYearLostShip());
    }

    @Override
    public int getYearLostShip() {
        return yearLostShip;
    }
}
