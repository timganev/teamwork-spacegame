

import core.EngineImpl;
import constants.GameBoard;
import core.contracts.Engine;
import core.factories.Factory;
import core.factories.FactoryImpl;
import enums.PropulsionType;
import ships.StarShipProbeImpl;
import ships.SystemShipGuardianImpl;
import ships.shipContracts.StarShip;
import ships.shipContracts.StarShipProbe;
import ships.shipContracts.SystemShipGuardian;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(GameBoard.spacegame);
        Factory factory = new FactoryImpl();
        Engine engine = new EngineImpl(factory);
        engine.start();




    }
}

