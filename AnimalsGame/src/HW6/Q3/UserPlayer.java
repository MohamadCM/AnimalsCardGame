package HW6.Q3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates player that users interact with
 * in order to play the game,
 * this is a subclass of Player
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class UserPlayer extends Player{
    public UserPlayer(String name)
    {
        super(name);
    }
    private ArrayList<Animal> chooseAnimals()
    {
        System.out.println("Please choose animals to attack with, use something other than integer numbers to finish;");
        ArrayList<Animal> outAnimals = new ArrayList<Animal>();
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            int num;
            try{
                num = Integer.parseInt(scanner.next());
            }catch (Exception e){
                System.out.println("Stopping the process");
                break;
            }
            if(num >= animals.size())
            {
                System.out.println("Wrong numbers, try again");
                continue;
            }
            if(outAnimals.contains(animals.get(num)))
                continue;
            outAnimals.add(animals.get(num));
        }
        return outAnimals;
    }
    @Override
    public void chooseAttack()
    {
        ArrayList<Animal> outAnimals = chooseAnimals();
        System.out.println("Please select an animal to attack to,");
        int animalToAttack;
        while (true)
        {
            try {
                Scanner scanner = new Scanner(System.in);
                animalToAttack = scanner.nextInt();
            }catch (Exception e)
            {
                System.out.println("Wrong input, try again!");
                Scanner scanner = new Scanner(System.in);
                animalToAttack = scanner.nextInt();
            }
            if(animalToAttack < 10 && !oppnentPlayer.getAnimals().get(animalToAttack).isDead())
                break;
            System.out.println("Wrong input, try again!");
        }
        String attackType;
        while (true)
        {
            System.out.println("Please choose attackType");
            Scanner scanner = new Scanner(System.in);
            attackType = scanner.nextLine();
            if(doAttack(animalToAttack, outAnimals , attackType))
            {
                System.out.println("Successful attack!");
                break;
            }
            System.out.println("Unable to attack please change animals and attack type");
            outAnimals = chooseAnimals();
        }

    }

    private boolean doAttack(int enemyAnimalNumber, ArrayList<Animal> givenAnimals, String attackType) {
        if(attackType.equals("-"))
            return false;
        int sumOfPowers = 0;
        for(int i = 0 ; i < givenAnimals.size() ; i++)
        {
            if(attackType.equals(givenAnimals.get(i).getAttackType1())) {
                if(givenAnimals.get(i).getAttackType1Power() >= givenAnimals.get(i).getStamina())
                {
                    System.out.println("Insufficient stamina");
                    return false;
                }
                sumOfPowers += givenAnimals.get(i).getAttackType1Power();
            }
            else if(attackType.equals(givenAnimals.get(i).getAttackType2())) {
                if(givenAnimals.get(i).getAttackType2Power() >= givenAnimals.get(i).getStamina())
                {
                    System.out.println("Insufficient stamina");
                    return false;
                }
                sumOfPowers += givenAnimals.get(i).getAttackType2Power();
            }
            else
                return false;
        }
        oppnentPlayer.getAnimals().get(enemyAnimalNumber).setHealth(oppnentPlayer.getAnimals().get(enemyAnimalNumber).getHealth() - sumOfPowers) ;
        for(int i = 0 ; i < givenAnimals.size() ; i++)
        {
            givenAnimals.get(i).setStamina(givenAnimals.get(i).getStamina() - (sumOfPowers / givenAnimals.size()));
        }
        return true;
    }

    @Override
    public boolean regainStamina() {
        if(numberOfRegains == 3)
        {
            System.out.println("You have no regains left");
            return false;
        }
        System.out.println("Please choose an animal to regain stamina");
        int num;
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
            }catch (Exception e)
            {
                System.out.println("Wrong input, try again");
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
            }
            if(num < animals.size())
                break;
            System.out.println("Wrong input, try again");
        }
        if(animals.get(num).getName().equals("Lion"))
        {
            animals.get(num).setStamina(1000);
            numberOfRegains++;
            return true;
        }
        if(animals.get(num).getName().equals("Bear"))
        {
            animals.get(num).setStamina(900);
            numberOfRegains++;
            return true;
        }
        if(animals.get(num).getName().equals("Tiger"))
        {
            animals.get(num).setStamina(850);
            numberOfRegains++;
            return true;
        }

        if(animals.get(num).getName().equals("Vulture"))
        {
            animals.get(num).setStamina(650);
            numberOfRegains++;
            return true;
        }

        if(animals.get(num).getName().equals("Fox"))
        {
            animals.get(num).setStamina(600);
            numberOfRegains++;
            return true;
        }

        if(animals.get(num).getName().equals("Elephant"))
        {
            animals.get(num).setStamina(500);
            numberOfRegains++;
            return true;
        }

        if(animals.get(num).getName().equals("Wolf"))
        {
            animals.get(num).setStamina(700);
            numberOfRegains++;
            return true;
        }

        if(animals.get(num).getName().equals("Pork"))
        {
            animals.get(num).setStamina(500);
            numberOfRegains++;
            return true;
        }
        if(animals.get(num).getName().equals("Hippo"))
        {
            animals.get(num).setStamina(360);
            numberOfRegains++;
            return true;
        }
        if(animals.get(num).getName().equals("Cow"))
        {
            animals.get(num).setStamina(400);
            numberOfRegains++;
            return true;
        }
        if(animals.get(num).getName().equals("Rabbit"))
        {
            animals.get(num).setStamina(350);
            numberOfRegains++;
            return true;
        }
        if(animals.get(num).getName().equals("Turtle"))
        {
            animals.get(num).setStamina(230);
            numberOfRegains++;
            return true;
        }

        return false;
    }
    /**
     * Lets the player too choose animals from random cards
     */
    @Override
    public void chooseNewAnimals() {
        System.out.println("Please choose animals you want(you should select 10 animals)");
        ArrayList<Animal> finalAnimals = new ArrayList<Animal>();
        for(int i = 0 ; i < 10 ; i++)
        {
            int num;
            while (true)
            {
                try {
                    Scanner scanner = new Scanner(System.in);
                    num = scanner.nextInt();
                }catch (Exception e)
                {
                    System.out.println("Wrong input,Try this one again");
                    Scanner scanner = new Scanner(System.in);
                    num = scanner.nextInt();
                }
                if(num < animals.size() && !finalAnimals.contains(animals.get(num)))
                    break;
                System.out.println("Wrong number, try again");
            }
            finalAnimals.add(animals.get(num));
        }
        animals = finalAnimals;
    }

}
