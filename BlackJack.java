//Jenna Lambert
//Zach Wilson
//Lab 03
package blackjack;
import java.util.Scanner;
import java.util.Random;
public class BlackJack {
    public static void main(String[] args) {
      //DECLARING VARIABLES
      Random rand = new Random();
      Scanner sc = new Scanner(System.in);
      int max = 10;
      int min = 1;
      int blackJack = 21;
      int dealerFaceUp;
      int dealerFaceDown;
      int player1;
      int player2;
      int card;
      int userSum;
      int dealerSum;
      char hitStay;
      char playAgain;
      //PLAY THE GAME
      do{
        //RANDOMIZING AND SETTING VALUES
        dealerFaceUp = rand.nextInt((max - min) + 1) + min;
        dealerFaceDown = rand.nextInt((max - min) + 1) + min;
        player1 = rand.nextInt((max - min) + 1) + min;
        player2 = rand.nextInt((max - min) + 1) + min;
        userSum = player1 + player2;
        dealerSum = dealerFaceUp + dealerFaceDown;
        //SHOWING THE USER THEIR HAND
        System.out.println("The dealer's card is " + dealerFaceUp +".\n");
        System.out.println("Your cards are " + player1 + " and " + player2 + ".");
        System.out.println("The sum of your cards is " + userSum + ".\n");
        //HIT OR STAY?
        System.out.println("Do you want to hit or stay (h/s)?");
        hitStay = sc.next().charAt(0);
        while (hitStay == 'h' || hitStay == 'H'){
           card = rand.nextInt((max - min) + 1) + min;
           userSum = userSum + card;
           System.out.println("The sum of your cards is now " + userSum + ".\n");
           if (userSum > blackJack){
              System.out.println("BUST!");
              break;
            }
            else {
              System.out.println("Would you like to hit or stay (h/s)?");
              hitStay = sc.next().charAt(0);
            }
        }
        //SHOWING RESULTS     
        if (userSum > dealerSum && userSum <= 21 || userSum == 21){
          System.out.println("Congrats! You win!");
        }
        else {
          System.out.println("Better luck next time.");
        }
        System.out.println("Dealers Hand: " + dealerSum);
        System.out.println("Your Hand: " + userSum);
        //PLAY AGAIN?
        System.out.println("Do you want to play again (y/n)?");
        playAgain = sc.next().charAt(0);
        }while(playAgain == 'y' || playAgain == 'Y');
    }
}