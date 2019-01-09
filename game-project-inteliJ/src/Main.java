

import core.EngineImpl;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.AgencyFactory;
import core.factories.AgencyFactoryImpl;
import enums.HostStarType;
import enums.PropulsionType;
import enums.WeaponsType;
import ships.*;
import ships.shipContracts.*;
import spaceObjects.PlanetImpl;
import spaceObjects.contracts.Planet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(GameBoard.spacegame);
        AgencyFactory factory = new AgencyFactoryImpl();
        Engine engine = new EngineImpl(factory);
        engine.start();


    }
}

