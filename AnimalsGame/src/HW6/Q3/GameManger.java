package HW6.Q3;

import java.util.ArrayList;

/**
 * This class is used to start the game ans sets the players
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class GameManger {
    public static void main(String[] args) {
        UserPlayer p1 = new UserPlayer("Mohamad");
        ArrayList<Animal> animals = new ArrayList<Animal>();
        Animal animal1 = new Animal("Lion",1000,900);
        animal1.setAttackType1("Run");
        animal1.setAttackType1Power(150);
        animals.add(animal1);
        Animal animal2 = new Animal("Bear",900,0);
        animal2.setAttackType1("injure");
        animal2.setAttackType1Power(130);
        animals.add(animal2);
        p1.setAnimals(animals);
        p1.updateAnimals();
        p1.printCards();
    }
}
