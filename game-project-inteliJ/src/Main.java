

import core.EngineImpl;
import core.GameBoard;
import core.contracts.Engine;
import core.factories.Factory;
import core.factories.FactoryImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(GameBoard.spacegame);
        Factory factory = new FactoryImpl();
        Engine engine = new EngineImpl(factory);
        engine.start();


    }
}

