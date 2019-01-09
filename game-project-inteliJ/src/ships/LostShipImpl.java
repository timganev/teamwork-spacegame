package ships;

import core.GameBoard;
import enums.PropulsionType;


public class LostShipImpl extends ShipBase {


    private int yearLostShip;

    public LostShipImpl(String shipName, int destination) {
        super(shipName, destination);
        this.yearLostShip = GameBoard.getYear();
    }


    public int getYearLostShip() {
        return yearLostShip;
    }

    @Override
    public void setShipName(String shipName) {
        super.shipName = "Lost Ship" + getShipId();
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
    public void next() {}

    @Override
    public void next(int years) {}

    @Override
    public String toString() {
        return String.format(super.toString() +
                "Lost in year:  %d" + System.lineSeparator(),getYearLostShip());
    }

}
