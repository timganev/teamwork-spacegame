

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


//        Planet saaas1 = new PlanetImpl("Mars1", "Slynce", HostStarType.YELLOW, 4, 4, 2, 24, 253, 0);
//        Planet saaas2 = new PlanetImpl("Mars2", "Slynce", HostStarType.YELLOW, 4, 4, 2, 24, 253, 0);
//        Planet saaas3 = new PlanetImpl("Mars3", "Slynce", HostStarType.YELLOW, 4, 4, 2, 24, 253, 0);
//
//
        StarShipColonial colon = new StarShipColonialImpl(PropulsionType.ANTIMMATER, "Apolo", 4555, 45874);
        StarShipProbe probe = new StarShipProbeImpl(PropulsionType.ANTIMMATER, "Apolo", 45557);
        SystemShipGuardian guard = new SystemShipGuardianImpl(WeaponsType.ROCKETS_AND_LASERS, true, 45874);
        SystemShipMinning mining = new SystemShipMinningImpl("Mining1", 69854, true);
        SystemShipSolar solar = new SystemShipSolarImpl("Solar1", 25634, false);
        SystemShipSolar solar2 = new SystemShipSolarImpl("Solar1", 25634, false);

//        System.out.println(colon.toString());
//        System.out.println();
//        colon.next();
//        System.out.println(colon.toString());
//        colon.next(10);
//        System.out.println(colon.toString());
//        System.out.println();
//
//        System.out.println(probe.toString());
//        System.out.println();
//        probe.next();
//        System.out.println(probe.toString());
//        probe.next(10);
//        System.out.println(probe.toString());
//        System.out.println();
//
//        System.out.println(guard.toString());
//        System.out.println();
//        guard.next();
//        System.out.println(guard.toString());
//        guard.next(10);
//        System.out.println(guard.toString());
//        System.out.println();
//
//        System.out.println(mining.toString());
//        System.out.println();
//        mining.next();
//        System.out.println(mining.toString());
//        mining.next(10);
//        System.out.println(mining.toString());
//        System.out.println();
//
//        System.out.println(solar.toString());
//        System.out.println();
//        solar.next();
//        System.out.println(solar.toString());
//        solar.next(3);
//        System.out.println(solar.toString());
//        System.out.println();
//        solar.next();
//        System.out.println(solar.toString());


    }
}

