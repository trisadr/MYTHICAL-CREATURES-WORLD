package Mythical_Creatures_Ecosystem.creatures;

import java.util.*;

public abstract class MythicalCreature {
    private String name;   //uSE Access modifier private for name
    protected int health;   //protected for subclass or in package
    int defense;    //default acces modifier
    public int power;  //use public so can access anywhere

    //constructor
    public MythicalCreature(String name,int health, int defense, int power){
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.power = power;  
    }

    //getter
    public String getName(){return name;}

    public int getDefense(){return defense;}

    //getter for health 
    public int getHealth(){return health;}

    //setter if have any decresed
     public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public abstract void displayStatus();

    public void attack(MythicalCreature obj){
        Random rand = new Random();
        int base = this.power+rand.nextInt(40);
        int damage = Math.max(15, base-(obj.defense / 2));

        obj.health-=damage;
        System.out.println(Constants.RED+this.name +" powers " 
                + obj.getName() + " for " +damage + " damage!" + Constants.RESET);
    }

    public void checkNeeds(boolean foodAvailable, boolean waterAvailable) {
        if (!foodAvailable || !waterAvailable) {
            setHealth(getHealth() - 10);
            System.out.println(Constants.RED + name 
                + " is lacking needs!\nHealth decreased" + Constants.RESET);
        } else {
            System.out.println(name + " stays healthy");
        }
    }
}
