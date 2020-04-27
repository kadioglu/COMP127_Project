package Hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Hangman {

    private List<String> words = new ArrayList<>();// wordlist
    private Random random;
    private ArrayList<String> usedLetters;
    private static int guessesLeft = 6;
    private Scanner scan = new Scanner(System.in);

    public Hangman() {
        startGame();
    }


    /**
     * Based on the response the player enters, it will either end
     * the game or start it again
     * @param response
     */
    private void playAgain(String response) {
        if (response.equalsIgnoreCase("y")) {
            System.out.println("We're playing again");
            // startGame();
        }
        else {
            System.out.println("Game Over. Thanks for playing");
        }
    }

    /**
     * Initializes the game of hangman
     */
    private void startGame() {
        //pick random word--can be method or through random generator here
        String hiddenWord = "vanilla"; // for testing
        for (int i = 0; i < hiddenWord.length(); i++) {
            System.out.print(" - ");
        }
        System.out.println("\nYou have " + guessesLeft + " guesses left");

        win(); // here for testing purposes

        userGuesses();
    }

    /**
     * This method should keep track of the lives left and what letters
     * have been used. Maybe even keep track if they won or lost
     */
    private void userGuesses() {

    }

    /**
     * This method is to signal the player that they won and asks if 
     * they want to play again
     */
    private void win() {
        System.out.println("Congrats! You won! Would you like to play again? (Type \"y\" or \"n\")");
       playAgain(scan.nextLine());
    }

    /**
     * This method is to signal the player that they lost and asks if 
     * they want to play again
     */
    private void lose() {
        System.out.println("I'm sorry, but you lost. Would you like to play again? (Type \"y\" or \"n\")");
       playAgain(scan.nextLine());
    }

    public static void main (String args[]) {
        Hangman game = new Hangman();
    }
}
