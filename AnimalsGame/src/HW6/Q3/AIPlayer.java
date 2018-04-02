package HW6.Q3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is used to create AI players
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class AIPlayer extends Player {
    /**
     * AI player needs nothing to get created at first
     */
    public AIPlayer()
    {
        super("Computer");
    }

    @Override
    public void chooseAttack() {
        Random random = new Random();
        while (true) {
            int attackWithAnimal = random.nextInt(animals.size());
            int typeOfAttackRandom = random.nextInt(2);
            String typeOfAttack;
            if (typeOfAttackRandom == 1 && !animals.get(attackWithAnimal).getAttackType2().equals("-"))
                typeOfAttack = animals.get(attackWithAnimal).getAttackType2();
            else
                typeOfAttack = animals.get(attackWithAnimal).getAttackType2();
            ArrayList<Animal> outAnimal = new ArrayList<Animal>();
            outAnimal.add(animals.get(attackWithAnimal));
            if (doAttack(random.nextInt(oppnentPlayer.getAnimals().size()), outAnimal, typeOfAttack))
                break;
        }
    }
    private boolean doAttack(int enemyAnimalNumber, ArrayList<Animal> givenAnimals, String attackType) {
        if(attackType.equals("-"))
            return false;
        int sumOfPowers = 0;
        for(int i = 0 ; i < givenAnimals.size() ; i++)
        {
            if(attackType.equals(givenAnimals.get(i).getAttackType1())) {
                if(givenAnimals.get(i).getAttackType1Power() > givenAnimals.get(i).getStamina())
                {
                    return false;
                }
                sumOfPowers += givenAnimals.get(i).getAttackType1Power();
            }
            else if(attackType.equals(givenAnimals.get(i).getAttackType2())) {
                if(givenAnimals.get(i).getAttackType2Power() > givenAnimals.get(i).getStamina())
                {
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
            return false;
        }
        int num;
        Random random = new Random();
        num = random.nextInt(animals.size());
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

    @Override
    public void chooseNewAnimals() {
        for (int i = 0 ; i < animals.size() ; i++)
            for (int j = 0 ; j < animals.size() -1 ; j++) {
                if (animals.get(j).getHealth() < animals.get(j + 1).getHealth()) {
                    Animal tmpAnimal = animals.get(j);
                    animals.set(j, animals.get(j + 1));
                    animals.set(j + 1, tmpAnimal);
                } else if (animals.get(j).getHealth() == animals.get(j + 1).getHealth() && animals.get(j).getAttackType1Power() < animals.get(j + 1).getAttackType1Power()) {
                    Animal tmpAnimal = animals.get(j);
                    animals.set(j, animals.get(j + 1));
                    animals.set(j + 1, tmpAnimal);
                } else if (animals.get(j).getHealth() == animals.get(j + 1).getHealth() && animals.get(j).getAttackType1Power() == animals.get(j + 1).getAttackType1Power() && animals.get(j).getAttackType2Power() < animals.get(j + 1).getAttackType2Power()) {
                    Animal tmpAnimal = animals.get(j);
                    animals.set(j, animals.get(j + 1));
                    animals.set(j + 1, tmpAnimal);
                }
            }
        while (animals.size() > 10){
        animals.remove(10);
        }
    }

}
