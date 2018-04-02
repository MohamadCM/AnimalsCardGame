package HW6.Q3;

import java.util.ArrayList;
import java.util.Random;

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
        animals = new ArrayList<Animal>();
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
            if(i < 10)
            System.out.printf("|Name:%9s(%s)|",animals.get(i).getName(),"0" + i);
            else
                System.out.printf("|Name:%9s(%s)|",animals.get(i).getName(),i);
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

    /**
     * This method is used to choose animals at the beginning of the game
     */
    abstract public void chooseNewAnimals();
    protected void randomFeedAnimals()
    {
        Random random = new Random();
        int[] counter = new int[12];
        for(int i = 0 ; i < 12 ; i++)
            counter[i] = 0;
        for(int i = 0 ; i < 30 ; i++)
        {
            int a = random.nextInt(12);
            if(a == 0)
            {
                if(counter[0] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Lion",1000,500);
                animal.setAttackType1("injure");
                animal.setAttackType1Power(150);
                animal.setAttackType2("kill");
                animal.setAttackType2Power(500);
                animals.add(animal);
                counter[0]++;
            }
            if(a == 1)
            {
                if(counter[1] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Bear",900,850);
                animal.setAttackType1("injure");
                animal.setAttackType1Power(130);
                animal.setAttackType2("kill");
                animal.setAttackType2Power(600);
                animals.add(animal);
                counter[1]++;
            }
            if(a == 2)
            {
                if(counter[2] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Tiger",850,850);
                animal.setAttackType1("injure");
                animal.setAttackType1Power(120);
                animal.setAttackType2("kill");
                animal.setAttackType2Power(650);
                animals.add(animal);
                counter[2]++;
            }
            if(a == 3)
            {
                if(counter[3] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Vulture",650,350);
                animal.setAttackType1("injure");
                animal.setAttackType1Power(100);
                animal.setAttackType2("-");
                animals.add(animal);
                counter[3]++;
            }
            if(a == 4)
            {
                if(counter[4] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Fox",600,400);
                animal.setAttackType1("injure");
                animal.setAttackType1Power(150);
                animal.setAttackType2("-");
                animals.add(animal);
                counter[4]++;
            }
            if(a == 5)
            {
                if(counter[5] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Elephant",500,1200);
                animal.setAttackType1("hurt");
                animal.setAttackType1Power(70);
                animal.setAttackType2("attack");
                animal.setAttackType2Power(50);
                animals.add(animal);
                counter[5]++;
            }
            if(a == 6)
            {
                if(counter[6] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Wolf",700,400);
                animal.setAttackType1("kill");
                animal.setAttackType1Power(700);
                animal.setAttackType2("-");
                animals.add(animal);
                counter[6]++;
            }
            if(a == 7)
            {
                if(counter[7] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Pork",500,1100);
                animal.setAttackType1("hurt");
                animal.setAttackType1Power(80);
                animal.setAttackType2("-");
                animals.add(animal);
                counter[7]++;
            }
            if(a == 8)
            {
                if(counter[0] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Hippo",360,1000);
                animal.setAttackType1("attack");
                animal.setAttackType1Power(110);
                animal.setAttackType2("-");
                animals.add(animal);
                counter[8]++;
            }
            if(a == 9)
            {
                if(counter[0] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Cow",400,750);
                animal.setAttackType1("attack");
                animal.setAttackType1Power(90);
                animal.setAttackType2("injure");
                animal.setAttackType2Power(100);
                animals.add(animal);
                counter[9]++;
            }
            if(a == 10)
            {
                if(counter[10] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Rabbit",350,200);
                animal.setAttackType1("bite");
                animal.setAttackType1Power(80);
                animal.setAttackType2("-");
                animals.add(animal);
                counter[10]++;
            }
            if(a == 11)
            {
                if(counter[11] >= 4)
                {
                    i--;
                    continue;
                }
                Animal animal = new Animal("Turtle",230,200);
                animal.setAttackType1("bite");
                animal.setAttackType1Power(200);
                animal.setAttackType2("-");
                animals.add(animal);
                counter[11]++;
            }
        }
    }
}
