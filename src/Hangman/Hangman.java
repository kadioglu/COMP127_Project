package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Hangman {

    // Esra Idea: Use maps w/ numbers as keys and words as values and just pull value from random key
    private List<String> words = new ArrayList<>();// wordlist ( Would like to be able to pull from a list of words online for this one.)
    private Random random;
    private static int guessesLeft = 6;
    private Scanner scan = new Scanner(System.in);
    private Scanner file = new Scanner(new File("COMP127_Project\\HangmanWords.txt"));
    private Set<Character> guesses;
    private String randomWord;
    private char guessedLetter;
    private char[] genRandomLetter;
    private char[] genRandomLetter2;

    private HangmanDisplay hangmanDisplay;

    public Hangman() throws FileNotFoundException {
        startGame();
    }


    /**
     * Based on the response the player enters, it will either end
     * the game or start it again
     * @param response
     */
    private void playAgain(String response) {
        if (response.equalsIgnoreCase("y")) {
            System.out.println("We're playing again\n");
            guesses.clear();
            hangmanDisplay.clearTheScreen();
            guessesLeft = 6;
            startGame();

        }
        else {
            hangmanDisplay.closeCanvas();
            System.out.println("Game Over. Thanks for playing");
        }
    }

    /**
     * Initializes the game of hangman
     */
    private void startGame() {
        System.out.println("\nYou have " + guessesLeft + " guesses left");

        hangmanDisplay = new HangmanDisplay();
        generateWord();
        userGuesses();
    }

    private void generateWord() {
        while(file.hasNext()){
            words.add(file.nextLine());
        }
        int randomNumber = (int) Math.ceil(Math.random() * (words.size()-1));
        randomWord = words.get(randomNumber);
        genRandomLetter = randomWord.toCharArray();
        genRandomLetter2 = randomWord.toCharArray();
        for (int i = 0; i<genRandomLetter.length;i++) {
            genRandomLetter[i] = '-';
        }

    }

    /**
     * This method should keep track of the lives left and what letters
     * have been used. Maybe even keep track if they won or lost
     */
    private void userGuesses() {
        guesses = new HashSet<Character>();
        do {
            System.out.println("Guess a letter.");
            System.out.println(String.valueOf(genRandomLetter));
            guessedLetter = scan.next().charAt(0);
            if (guesses.contains(guessedLetter)){
                System.out.println("You've already guessed this letter before. Try again.");
            }

            else {
                guesses.add(guessedLetter);
                checkGuess();
            }
            if (Arrays.equals(genRandomLetter,genRandomLetter2)){
                break;
            }
        } while(guessesLeft!=0);
        if (guessesLeft == 0) {
            lose();
        }
        else {
            win();
        }
    }

    /**
     * Method checks if the guess is in the hidden word
     */
    private void checkGuess() {
        boolean found = false;
        for (int i = 0; i < genRandomLetter.length; i++){
            if (genRandomLetter2[i] == guessedLetter){
                genRandomLetter[i] = guessedLetter;
                found = true;
            }
        }
        if (!found){
            System.out.println("Wrong letter, try again!");
            guessesLeft--;
            hangmanDisplay.addPart(guessesLeft);
            System.out.println("Guesses left " + guessesLeft);
        }
    }

    /**
     * This method is to signal the player that they won and asks if 
     * they want to play again
     */
    private void win() {
        System.out.println(randomWord);
        System.out.println("Congrats! You won! Would you like to play again? (Type \"y\" to play again)");
        playAgain(scan.next());
    }

    /**
     * This method is to signal the player that they lost and asks if 
     * they want to play again
     */
    private void lose() {
        hangmanDisplay.addPart(guessesLeft);
        System.out.println("I'm sorry, but you lost. The word was: " + randomWord + ". " +
                "Would you like to play again? (Type \"y\" to play again)");
       playAgain(scan.next());
    }

    public static void main (String args[]) throws FileNotFoundException {
        Hangman game = new Hangman();
    }
}
