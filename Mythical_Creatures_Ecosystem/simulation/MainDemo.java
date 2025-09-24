package Mythical_Creatures_Ecosystem.simulation;

import Mythical_Creatures_Ecosystem.creatures.*;  //import all class in package MythicalCreatures
import java.util.*;  //   import all class in package java.util

public class MainDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==============================================");
        System.out.println("|      Mythical MythicalCreatures World      |");
        System.out.println("==============================================");
        System.out.println("|    1. Battle Mode (Dragon vs Phoenix)      |");
        System.out.println("|    2. Ecosystem Simulation                 |");
        System.out.println("----------------------------------------------");
        System.out.print("Choose option : ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            BattleMode demo = new BattleMode();
            demo.runBattleDemo();
        }else if (choice == 2) {
            EcosystemSimulation eco = new EcosystemSimulation();
            eco.runSimulation(5);
        } else {
            System.out.println(Constants.RED+"INVALID OPTION" + Constants.RESET);
        }
        scanner.close();
    }
}
