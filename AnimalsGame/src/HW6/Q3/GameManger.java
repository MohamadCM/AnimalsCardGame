package HW6.Q3;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is used to start the game ans sets the players
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class GameManger {
    public static void main(String[] args) {
        System.out.println("How do you want to play?!\n1- 1 Vs. 1\t\t\t2- 1 Vs. Computer");
        int flag;
        while (true)
        {
            try {
                Scanner scanner = new Scanner(System.in);
                flag = scanner.nextInt();
            }catch (Exception e)
            {
                System.out.println("Wrong input, try again!");
                Scanner scanner = new Scanner(System.in);
                flag = scanner.nextInt();
            }
            if(flag == 1 || flag == 2)
                break;
            System.out.println("Wrong input, try again!");
        }
        if(flag == 1){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Player1's name:");
            UserPlayer userPlayer1 = new UserPlayer(scanner.next());
            System.out.println("Enter Player2's name:");
            UserPlayer userPlayer2 = new UserPlayer(scanner.next());
            userPlayer1.randomFeedAnimals();
            userPlayer2.randomFeedAnimals();
            userPlayer1.printCards();
            System.out.println(userPlayer1.getName() + "'s turn to choose cards");
            userPlayer1.chooseNewAnimals();
            userPlayer2.printCards();
            System.out.println(userPlayer2.getName() + "'s turn to choose cards");
            userPlayer2.chooseNewAnimals();
            userPlayer1.setOppnentPlayer(userPlayer2);
            userPlayer2.setOppnentPlayer(userPlayer1);
            for(int i = 0 ; i < 500 ; i++)
                System.out.println();
            while (true)
            {
                userPlayer1.printCards();
                userPlayer2.printCards();
                System.out.println(userPlayer1.getName() + "'s turn");
                System.out.println("What do want to do?!\n1- Attack 2- Regain Stamina");
                int flag2;
                while (true)
                {
                    try {
                        Scanner scanner2 = new Scanner(System.in);
                        flag2 = scanner.nextInt();
                    }catch (Exception e)
                    {
                        System.out.println("Wrong input, try again!");
                        Scanner scanner2 = new Scanner(System.in);
                        flag2 = scanner.nextInt();
                    }
                    if (flag2 == 1 || flag2 == 2)
                        break;
                    System.out.println("Wrong input, try again!");
                }
                if (flag2 == 2) {
                    if(!userPlayer1.regainStamina())
                        System.out.println("Unable to regain stamina, switching to attack");
                    flag2 = 1;
                }
                if (flag2 == 1)
                    userPlayer1.chooseAttack();
                if (userPlayer1.isWon())
                    break;
                for (int i = 0 ; i < 100 ; i++)
                    System.out.println();
                userPlayer1.updateAnimals();
                userPlayer2.updateAnimals();
                userPlayer1.printCards();
                userPlayer2.printCards();
                System.out.println(userPlayer2.getName() + "'s turn");
                System.out.println("What do want to do?!\n1- Attack 2- Regain Stamina");
                while (true)
                {
                    try {
                        Scanner scanner2 = new Scanner(System.in);
                        flag2 = scanner.nextInt();
                    }catch (Exception e)
                    {
                        System.out.println("Wrong input, try again!");
                        Scanner scanner2 = new Scanner(System.in);
                        flag2 = scanner.nextInt();
                    }
                    if (flag2 == 1 || flag2 == 2)
                        break;
                    System.out.println("Wrong input, try again!");
                }
                if (flag2 == 2) {
                    if(!userPlayer2.regainStamina())
                        System.out.println("Unable to regain stamina, switching to attack");
                    flag2 = 1;
                }
                if (flag2 == 1)
                    userPlayer2.chooseAttack();
                if (userPlayer2.isWon())
                    break;
                userPlayer1.updateAnimals();
                userPlayer2.updateAnimals();
            }
            if (userPlayer1.isWon())
                System.out.println(userPlayer1.getName() + " Won the game");
            else
                System.out.println(userPlayer2.getName() + " Won the game");
        }
        else if(flag == 2)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Player1's name:");
            UserPlayer userPlayer1 = new UserPlayer(scanner.next());
            AIPlayer aiPlayer = new AIPlayer();
            userPlayer1.randomFeedAnimals();
            aiPlayer.randomFeedAnimals();
            userPlayer1.printCards();
            System.out.println(userPlayer1.getName() + "'s turn to choose cards");
            userPlayer1.chooseNewAnimals();
            aiPlayer.printCards();
            System.out.println(aiPlayer.getName() + "'s turn to choose cards");
            aiPlayer.chooseNewAnimals();
            userPlayer1.setOppnentPlayer(aiPlayer);
            aiPlayer.setOppnentPlayer(userPlayer1);
            for(int i = 0 ; i < 500 ; i++)
                System.out.println();
            while (true)
            {
                userPlayer1.printCards();
                aiPlayer.printCards();
                System.out.println(userPlayer1.getName() + "'s turn");
                System.out.println("What do want to do?!\n1- Attack 2- Regain Stamina");
                int flag2;
                while (true)
                {
                    try {
                        Scanner scanner2 = new Scanner(System.in);
                        flag2 = scanner.nextInt();
                    }catch (Exception e)
                    {
                        System.out.println("Wrong input, try again!");
                        Scanner scanner2 = new Scanner(System.in);
                        flag2 = scanner.nextInt();
                    }
                    if (flag2 == 1 || flag2 == 2)
                        break;
                    System.out.println("Wrong input, try again!");
                }
                if (flag2 == 2) {
                    if(!userPlayer1.regainStamina())
                        System.out.println("Unable to regain stamina, switching to attack");
                        flag2 = 1;
                }
                if (flag2 == 1)
                    userPlayer1.chooseAttack();
                if (userPlayer1.isWon())
                    break;
                for (int i = 0 ; i < 100 ; i++)
                    System.out.println();
                userPlayer1.updateAnimals();
                aiPlayer.updateAnimals();
                userPlayer1.printCards();
                aiPlayer.printCards();
                System.out.println(aiPlayer.getName() + "'s turn");
                Random random = new Random();
                flag2 = random.nextInt(2) + 1;
                if (flag2 == 2) {
                    if(!aiPlayer.regainStamina())
                        flag2 = 1;
                }
                if (flag2 == 1)
                    aiPlayer.chooseAttack();
                if (aiPlayer.isWon())
                    break;
                userPlayer1.updateAnimals();
                aiPlayer.updateAnimals();
            }
            if (userPlayer1.isWon())
                System.out.println(userPlayer1.getName() + " Won the game");
            else
                System.out.println(aiPlayer.getName() + " Won the game");
            for (int i = 0 ; i < 100 ; i++)
                System.out.println();
        }
    }
}
