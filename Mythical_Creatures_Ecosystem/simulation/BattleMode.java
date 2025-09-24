package Mythical_Creatures_Ecosystem.simulation;

import Mythical_Creatures_Ecosystem.creatures.*;
import java.util.*;

public class BattleMode {
    // Use method public
    public void attack(MythicalCreature attacker, MythicalCreature defender) {
        Random rand = new Random();
        int damage = attacker.power + rand.nextInt(20) - (defender.getDefense()/2);
        if (damage < 1) damage = 10;
        defender.setHealth(defender.getHealth() - damage);

        System.out.println(Constants.RED+attacker.getName() + " attacks " 
                + defender.getName() + " for " + damage + " damage!"+Constants.RESET);
    }
    // Use method default
    void rest(MythicalCreature creature) {
        creature.setHealth(creature.getHealth() + 5);
        System.out.println(Constants.GREEN+creature.getName() + " takes a rest and recovers +5 HP"+Constants.RESET);
    }

    // Use method protected
    protected void heal(MythicalCreature creature, int amount) {
        creature.setHealth(creature.getHealth() + amount);
        System.out.println(Constants.GREEN+creature.getName() + " is healed by +" + amount + " HP"+Constants.RESET);
    }

    // Use method private
    private int calculateBaseDamage(MythicalCreature attacker) {
        Random rand = new Random();
        return attacker.power + rand.nextInt(20);
    }
    
    public void runBattleDemo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Constants.CYAN + "\n\n===========================================\n" + Constants.RESET);
        System.out.println(Constants.CYAN + "|     Battle Mode (Dragon vs Phoenix)     |\n" + Constants.RESET);
        System.out.println(Constants.CYAN + "===========================================\n" + Constants.RESET);

        MythicalCreature dragon = new Dragon("Draco");
        MythicalCreature phoenix = new Phoenix("Vierlly");

        System.out.println("\n--->> Battle Starts !!");
        dragon.displayStatus();
        phoenix.displayStatus();

        Random rand = new Random();
        while (dragon.getHealth() > 0 && phoenix.getHealth() > 0) {
            if (rand.nextBoolean()) {
                attack(dragon, phoenix);   
            } else {
                attack(phoenix, dragon);   
            }

            if (rand.nextInt(5) == 0) {
                rest(dragon);           
            }

            if (rand.nextInt(7) == 0) {
                heal(phoenix, 8);          
            }

            dragon.displayStatus();
            phoenix.displayStatus();

            try {
                Thread.sleep(1000); // delay time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String winner = (dragon.getHealth() > 0) ? dragon.getName() : phoenix.getName();
        int winnerHP = (winner.equalsIgnoreCase("Draco")) ? dragon.getHealth() : phoenix.getHealth();

        System.out.println(Constants.GREEN + "\nCongratulations !!\nThe winner is "
                + winner + " with HP " + winnerHP + Constants.RESET);

        scanner.close();
    }
}
