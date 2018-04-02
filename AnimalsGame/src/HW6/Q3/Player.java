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
    protected int numberOfRagains;
    /**
     * Each player needs name to get created
     * @param name
     */
    protected Player(String name) {
        this.name = name;
        numberOfRagains = 0;
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
        System.out.printf(String.format("%19s\n", name));
        System.out.println("#################################");
        for(int i = 0 ; i < animals.size() ; i++)
        {
            for(int j = 0 ; j < 20 ; j++)
                System.out.print("_");
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.printf("|Name:%10s(%d)|",animals.get(i).getName(),i);
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.printf("|%sHealth:%11s%s|","\u001B[31m",animals.get(i).getHealth(),"\u001B[0m");
            System.out.print("    ");
        }
        System.out.println();

        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.printf("|%sStamina:%10s%s|","\u001B[32m",animals.get(i).getStamina(),"\u001B[0m");
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.print("|");
            for(int j = 0 ; j < 18 ; j++)
                System.out.print("+");
            System.out.print("|");
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.printf("|%sAttack1:%10s%s|","\u001B[34m",animals.get(i).getAttackType1(),"\u001B[0m");
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.printf("|%sPower:%12s%s|","\u001B[34m",animals.get(i).getAttackType1Power(),"\u001B[0m");
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.printf("|%sAttack2:%10s%s|","\u001B[34m",animals.get(i).getAttackType2(),"\u001B[0m");
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            System.out.printf("|%sPower:%12s%s|","\u001B[34m",animals.get(i).getAttackType2Power(),"\u001B[0m");
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0 ; i < animals.size() ; i++)
        {
            for(int j = 0 ; j < 20 ; j++)
                System.out.print("-");
            System.out.print("    ");
        }
        System.out.println();
    }

    /**
     * This method is used to regain stamina for given animal
     * @return {@code true} if the process is successful, {@code false} otherwise
     */
    abstract public boolean regainStamina();

    /**
     * Updates stats of animals, like removing the dead ones
     */
    public void updateAnimals()
    {
        for(int i = 0 ; i < animals.size() ; i++)
        {
            if(animals.get(i).getHealth() <= 0)
                animals.remove(i);
        }
    }

    /**
     * Checks whether current player won the game or not
     * @return {@code true} if the player is Won, {@code false} otherwise
     */
    public boolean isWon()
    {
        if(oppnentPlayer.animals.size() == 0)
            return true;
        return false;
    }
}
