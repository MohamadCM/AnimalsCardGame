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
        p1.randomFeedAnimals();
        p1.printCards();
    }
}
