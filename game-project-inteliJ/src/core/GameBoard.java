package core;


public class GameBoard {
    public static int loadCounter = 0;
    public static int year = 2020;
    public static int yearColonialShipCapability = 2022;
    public static int yearExtinctionLevelEvent = 2025;
    public static int yearEndGame = 2500;
    public static int lightSpeed = 299729;

    //    public static int yearNukesDriveCapability = 2020;
    //    public static int yearFusionDriveCapability = 2020;
    //    public static int yearAntimeterDriveCapability = 2020;


    public static String spacegame =
            "     _______..______      ___       ______  _______      _______      ___      .___  ___.  _______    " + System.lineSeparator() +
                    "    /       ||   _  \\    /   \\     /      ||   ____|    /  _____|    /   \\     |   \\/   | |   ____|   " + System.lineSeparator() +
                    "   |   (----`|  |_)  |  /  ^  \\   |  ,----'|  |__      |  |  __     /  ^  \\    |  \\  /  | |  |__      " + System.lineSeparator() +
                    "    \\   \\    |   ___/  /  /_\\  \\  |  |     |   __|     |  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|     " + System.lineSeparator() +
                    ".----)   |   |  |     /  _____  \\ |  `----.|  |____    |  |__| |  /  _____  \\  |  |  |  | |  |____    " + System.lineSeparator() +
                    "|_______/    | _|    /__/     \\__\\ \\______||_______|    \\______| /__/     \\__\\ |__|  |__| |_______|   " + System.lineSeparator() +

                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&%#(/,,*##(##(%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&(..   *   *//****//,,,*(,....#&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&(......../...#%#(##,.......      #&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&%*...#......(...,/*.,..,,,,*/,..,/####(#%&@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&%/.,....(../,.......,,,,,*,,. ./#%%%%%%%%##(##@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,.,&&@@@@@@@@@@@@&&&%%#..,...(.......,,,,,,,*((#,./((#%%%%%%%%%%###/#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#(***,.%&&@@@@@&&&%%*   .*.,....,,,,,,,,#&(./%%%%%##%%%%%%%%%%%###(/%@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@(******..#&&&&%#.  .......,,,,,,,*%%%%%%##%%%%%&&&%%%%%%%####(//@@@@@&&&&&&&&&&&%%%%%%%%%######(((" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@(******,,...  .....,,.,,,,,*%&%%&&&&&&&&&&&&&&%%%%%%########(/*%&%%%%%%####(((///***,,,.....  ..." + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@/***,.   .......,,,,,,/&&&&&&&&&&&&&&&&&&%%%%%##########((/*///***,,.......   ..... ............" + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,.  .......,,,,,,#&&&&&&&&&&&&&&&&&&%%%%#############(/**,........................  ..........." + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&.......,,,,,,*%&&&&&&&&&&&&&&&&&%%%%%##############((/**...      ................................." + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,....,,,,,,,/&&&&&&&&&&&&&&&&&%%%%%%###############((/***........................ ................." + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&...,,,,,,#&&&&&&&&&&&&&&&%%%%%%%%################((/***.......... .......,.............             " + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&%%%/,,,,*%&&&&&&&&&&&&&&&&%%%%%%%###############(((/***.....      ...........                           " + System.lineSeparator() +
                    "@@@@@@@@@@@@@@@@@@&&&&&&%%%%###((/****(&&&&&&%%%&&&&&&&&%%%%%%%##########(((//////*,.  .              ..  ...  ..  ...............,,,,.,,," + System.lineSeparator() +
                    "@@@@@@@@@&&&&&&&%%%##((//**,,,,,,,,,.#%%%%%%%%%%&&&%%%%%%%##########((//***,.             .....   ........,,,..,,,,,...,,,,,,,,,,...   ..." + System.lineSeparator() +
                    "@&&&&&&%%%###(//**,,,,,............,,,%%%%&%.###%%##########((//*,.     ........................,.....,,,,,,,,,,,,,,.,,.. ,......,,,,,*,.." + System.lineSeparator() +
                    "%%###(//**,,,,,,......................(#//%&%############((/(((((,...............    .,,,,...,,,,,..,,,.,,..,.,,,,,*,,,,,.....,,..   ....," + System.lineSeparator() +
                    "**,,,,,........................     .//(&%########((*.........,....................,,.,,,,,,,,*******,.,***,,***************,,,,,,,***,..." + System.lineSeparator() +
                    ",.....................            ,//&%,....,,..............................,,..,,,,,,..,,,,,********************************,,. ...,,,,.," + System.lineSeparator() +
                    "..........  ,@@@@@*   .......,,,*/%%,......................,,,,,,,,,,.,.,,,....,*************************////////////////////////*******,," + System.lineSeparator() +
                    "......    .@&&%&%&@&...,,,...*#&%................,,,,,**,,,,,,,,,***,,,,,*******,,,,. .,*********///////////////*/////***,*,. ....,,*****/" + System.lineSeparator() +
                    System.lineSeparator() + "Write \"help\" to see all commands" + System.lineSeparator();


    public static int getYear() {
        return year;
    }
    public static void updateYear() {
        year++;
    }

    public static int getYearExtinctionLevelEvent() {
        return yearExtinctionLevelEvent;
    }

    public static int getYearEndGame() {
        return yearEndGame;
    }

    private void setYear(int year) {
        this.year = year;
    }

}
