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
        animal1.setAttackType1("injure");
        animal1.setAttackType1Power(150);
        animals.add(animal1);
        Animal animal2 = new Animal("Bear",900,850);
        animal2.setAttackType1("injure");
        animal2.setAttackType1Power(130);
        animals.add(animal2);
        p1.setAnimals(animals);
        UserPlayer p2 = new UserPlayer("MohamadCm");
        p2.setAnimals(animals);
        p1.printCards();
        p2.printCards();
        p1.setOppnentPlayer(p2);
        p2.setOppnentPlayer(p1);
        p1.chooseAttack();
        p1.printCards();
        p2.printCards();
    }
}
