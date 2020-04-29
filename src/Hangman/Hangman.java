package Hangman;

import java.util.*;


public class Hangman {

    private List<String> words = new ArrayList<>();// wordlist ( Would like to be able to pull from a list of words online for this one.)
    private Random random;
    private static int guessesLeft = 6;
    private Scanner scan = new Scanner(System.in);
    private Set<Character> guesses;
    private char guessedLetter;
    private char[] genRandomLetter;
    private char[] genRandomLetter2;

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
            guesses.clear();
            startGame();

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
       //String hiddenWord = "vanilla"; // for testing
       //for (int i = 0; i < hiddenWord.length(); i++) {
       //    System.out.print(" - ");
       //}
        System.out.println("\nYou have " + guessesLeft + " guesses left");

//        win(); // here for testing purposes
        generateWord();
        userGuesses();
    }

    private void generateWord() {
        words.add("gravity");
        words.add("vanilla");
        words.add("banana");
        int randomNumber = (int) Math.ceil(Math.random() * (words.size()-1));
        String randomWord = words.get(randomNumber);
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
        }while(guessesLeft!=0);
        if (guessesLeft == 0) {
            lose();
        }
        else {
            win();
        }
    }

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
            System.out.println("Guesses left " + guessesLeft);
        }
    }

    /**
     * This method is to signal the player that they won and asks if 
     * they want to play again
     */
    private void win() {
        System.out.println("Congrats! You won! Would you like to play again? (Type \"y\" or \"n\")");
        playAgain(scan.next());
    }

    /**
     * This method is to signal the player that they lost and asks if 
     * they want to play again
     */
    private void lose() {
        System.out.println("I'm sorry, but you lost. Would you like to play again? (Type \"y\" or \"n\")");
       playAgain(scan.next());
    }

    public static void main (String args[]) {
        Hangman game = new Hangman();
    }
}
