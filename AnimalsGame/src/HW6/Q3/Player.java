package HW6.Q3;

import java.util.ArrayList;

/**
 * This is class is used to create different kind of players
 * Other kind of players should inherit this class
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
abstract public class Player {
    private String name;
    protected ArrayList<Animal> animals;
    protected Player oppnentPlayer;

    /**
     * Each player needs name to get created
     * @param name
     */
    protected Player(String name) {
        this.name = name;
    }

    /**
     * @return an array of available animals
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * Sets a number of animals for player
     * @param animals
     */
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Sets the opponent player
     * @param oppnentPlayer
     */
    public void setOppnentPlayer(Player oppnentPlayer) {
        this.oppnentPlayer = oppnentPlayer;
    }

    /**
     *  This method is used to attack against opponents animals
     */
    abstract public void chooseAttack();
    public void printCards()
    {
        System.out.println("#################################");
        System.out.println(String.format("%20s", name));
        System.out.println("#################################");
    }
}
