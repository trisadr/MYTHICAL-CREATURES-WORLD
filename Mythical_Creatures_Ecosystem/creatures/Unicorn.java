package Mythical_Creatures_Ecosystem.creatures;

public class Unicorn extends MythicalCreature{
    public Unicorn(String name){
        super(name, 90, 20, 12);
    }
    @Override
    public void displayStatus() {
        System.out.println(Constants.PURPLE +  "Unicorn\n" +Constants.RESET+getName() +
         "Health: " + health +  " | Attack: " + power + " | Defense: " + defense);
    }

    @Override
    public void checkNeeds(boolean foodAvailable, boolean waterAvailable) {
        if (!waterAvailable) {
            setHealth(getHealth() - 12);
            System.out.println(Constants.RED + getName() + " desperately needs water!\nHealth decreased" + Constants.RESET);
        } else if (!foodAvailable) {
            setHealth(getHealth() - 5);
            System.out.println(Constants.RED + getName() + " is hungry!\nHealth decreased" + Constants.RESET);
        } else {
            System.out.println(getName() + " is calm and healthy");
        }
    }
}
