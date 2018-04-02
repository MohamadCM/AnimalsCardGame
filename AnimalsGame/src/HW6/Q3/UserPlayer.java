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
        System.out.println("Please choose animals to attack, use something other than integer numbers to finish");
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
            outAnimals.add(animals.get(num));
        }
        return outAnimals;
    }
    @Override
    public void chooseAttack()
    {
        ArrayList<Animal> outAnimals = chooseAnimals();
        System.out.println("Please select an animal to attack");
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

    @Override
    public boolean regainStamina() {
        if(numberOfRagains == 3)
        {
            System.out.println("You have no regains left");
            return false;
        }
        System.out.println("Please choose an animal to attack");
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
            numberOfRagains++;
            return true;
        }
        if(animals.get(num).getName().equals("Bear"))
        {
            animals.get(num).setStamina(900);
            numberOfRagains++;
            return true;
        }
        if(animals.get(num).getName().equals("Tiger"))
        {
            animals.get(num).setStamina(850);
            numberOfRagains++;
            return true;
        }

        if(animals.get(num).getName().equals("Vulture"))
        {
            animals.get(num).setStamina(650);
            numberOfRagains++;
            return true;
        }

        if(animals.get(num).getName().equals("Fox"))
        {
            animals.get(num).setStamina(600);
            numberOfRagains++;
            return true;
        }

        if(animals.get(num).getName().equals("Elephant"))
        {
            animals.get(num).setStamina(500);
            numberOfRagains++;
            return true;
        }

        if(animals.get(num).getName().equals("Wolf"))
        {
            animals.get(num).setStamina(700);
            numberOfRagains++;
            return true;
        }

        if(animals.get(num).getName().equals("Pork"))
        {
            animals.get(num).setStamina(500);
            numberOfRagains++;
            return true;
        }
        if(animals.get(num).getName().equals("Hippo"))
        {
            animals.get(num).setStamina(360);
            numberOfRagains++;
            return true;
        }
        if(animals.get(num).getName().equals("Cow"))
        {
            animals.get(num).setStamina(400);
            numberOfRagains++;
            return true;
        }
        if(animals.get(num).getName().equals("Rabbit"))
        {
            animals.get(num).setStamina(350);
            numberOfRagains++;
            return true;
        }
        if(animals.get(num).getName().equals("Turtle"))
        {
            animals.get(num).setStamina(230);
            numberOfRagains++;
            return true;
        }

        return false;
    }

    private boolean doAttack(int enemyAnimalNumber, ArrayList<Animal> givenAnimals, String attackType) {
        int sumOfPowers = 0;
        for(int i = 0 ; i < givenAnimals.size() ; i++)
        {
            if(attackType.equals(givenAnimals.get(i).getAttackType1())) {
                if(givenAnimals.get(i).getAttackType1Power() <= givenAnimals.get(i).getStamina())
                {
                    System.out.println("Insufficient stamina");
                    return false;
                }
                sumOfPowers += givenAnimals.get(i).getAttackType1Power();
            }
            else if(attackType.equals(givenAnimals.get(i).getAttackType2())) {
                if(givenAnimals.get(i).getAttackType2Power() <= givenAnimals.get(i).getStamina())
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

}
