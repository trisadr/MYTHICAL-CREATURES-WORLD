package Mythical_Creatures_Ecosystem.simulation;

import Mythical_Creatures_Ecosystem.creatures.*;
import java.util.*;

public class EcosystemSimulation {
    private List<MythicalCreature> creatures;
    private Random rand = new Random();
    //constructor
    public EcosystemSimulation() {
        creatures = new ArrayList<>();
        creatures.add(new Dragon("Draco"));
        creatures.add(new Phoenix("Vierlly"));
        creatures.add(new Unicorn("Luna"));
    }

    public void runSimulation(int days) {
        System.out.println(Constants.CYAN+"\n\n================================\n"+Constants.RESET);
        System.out.println(Constants.CYAN+"|     Ecosystem Simulation     |\n"+Constants.RESET);
        System.out.println(Constants.CYAN+"================================\n"+Constants.RESET);

        for (int day= 1;day <= days;day++) {
            System.out.println("\nDay " +day);

            boolean foodAvailable = rand.nextBoolean();
            boolean waterAvailable = rand.nextBoolean();

            System.out.println("\nFood available : " +foodAvailable + "\nWater available: " +waterAvailable+"\n");
            for (MythicalCreature obj: creatures) {
                obj.displayStatus();
                obj.checkNeeds(foodAvailable, waterAvailable);
            }
        }
    }
}


