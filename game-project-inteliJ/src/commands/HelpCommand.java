package commands;

import commands.contracts.Command;
import core.contracts.Engine;
import core.factories.Factory;

import java.util.List;


public class HelpCommand implements Command {
    private final Factory factory;
    private final Engine engine;

    public HelpCommand(Factory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;

    }

    public String execute(List<String> parameters) {


        return String.format(
                "List of commands :" +
                        System.lineSeparator() +
                        "1 next" +
                        System.lineSeparator() +
                        "2 load" +
                        System.lineSeparator() +
                        "3 listobjects" +
                        System.lineSeparator() +
                        "4 listships" +
                        System.lineSeparator() +
                        "5 createasteroidfield (example: createasteroidfield AlfaB Alfa blue 11 true true)" +
                        System.lineSeparator() +
                        "6 createplanet        (example: createplanet AlfaB Alfa blue 1.1 0.9 5 100 11 1115555)" +
                        System.lineSeparator() +
                        "7 createcolonialship  (example: createcolonialship Sail Ark 3000 100000)" +
                        System.lineSeparator() +
                        "8 createstarshiprobe  (example: createstarshiprobe Sail Dominator 100000)" +
                        System.lineSeparator() +
                        "9 createsystemshipguardian  (example: createsystemshipguardian Rocket true 75000)" +
                        System.lineSeparator() +
                        "10 createsystemshipminning  (example: createsystemshipminning Apolo11 75000 true)" +
                        System.lineSeparator() +
                        "11 createsystemshipsolar  (example: createsystemshipsolar Apolo9 75000 true)" +
                        System.lineSeparator() +
                        "11 send  (example: send 0 3)" +
                        System.lineSeparator() +
                        "11 lostship  (example: lostship 1)" +
                        System.lineSeparator() +
                        "12 exit"   +
                        System.lineSeparator() +

                        "listactiveships  TODO"   +
                        System.lineSeparator() +

                        "listlostships  TODO"   +
                        System.lineSeparator() +
                        "***********" +
                        System.lineSeparator());
    }

}


