package Mythical_Creatures_Ecosystem.creatures;

public class Phoenix extends MythicalCreature {
    public Phoenix(String name){
         super(name, 100, 30, 25);
    }
    @Override
    public void displayStatus() {
        System.out.println(Constants.YELLOW + "Phoenix\n" +Constants.RESET+getName() + "Health: " + health + 
            " | Attack: " + power + 
            " | Defense: " + defense);
    }

    @Override
    public void checkNeeds(boolean foodAvailable, boolean waterAvailable) {
        if (!foodAvailable ||!waterAvailable) {
            setHealth(getHealth()- 8);
            System.out.println(Constants.RED + getName() + " feels weak without resources" + Constants.RESET);
        } else {
            System.out.println(getName() + " shines brightly with energy");
        }
    }
}
