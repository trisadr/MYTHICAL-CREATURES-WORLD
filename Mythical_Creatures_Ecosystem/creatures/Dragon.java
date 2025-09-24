package Mythical_Creatures_Ecosystem.creatures;

public class Dragon extends MythicalCreature{
    public Dragon(String name){
        super(name, 120, 30, 20);
    }

    @Override
    public void displayStatus() {
        System.out.println(Constants.BLUE + 
            "Dragon\n"+Constants.RESET+getName()+"Health: "+health+ 
            " | Attack: "+power + 
            " | Defense: "+defense);
    }
    @Override
    public void checkNeeds(boolean foodAvail, boolean waterAvailable) {
        if (!foodAvail) {
            setHealth(getHealth()-15); 
            System.out.println(Constants.RED + getName() + " is starving!\nHealth decreased"+Constants.RESET);
        } else if (!waterAvailable) {
            setHealth(getHealth()-5); 
            System.out.println(Constants.RED + getName() + " is thirsty!\nHealth decreased" + Constants.RESET);
        } else {
            System.out.println(getName() + " is satisfied and roars happily");
        }
    }
}


