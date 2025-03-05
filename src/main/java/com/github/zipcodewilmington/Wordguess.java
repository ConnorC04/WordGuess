package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Scanner;

public class Wordguess {

    String[] wordBank = {"cat", "dog", "laptop", "zipcode", "spiderman"};


    public void runGame(String[] wb) {

        Scanner scan = new Scanner(System.in);

        String playAgain = "";

        //wordToGuess is now the random word from the wordBank
        String wordToGuess = randWord(wb);

        //guessesLeft is equal to the length of wordToGuess
        int guessesLeft = setGuess(wordToGuess);

        boolean gameOn = (guessesLeft > 0);

        //player array is a blank array with '_' the length of wordToGuess
        char[] playerArray = setPlayerArr(wordToGuess);
        //game array is an array with the length and chars of wordToGuess
        char[] gameArray = setGameArr(wordToGuess);


        System.out.println("Let't Play Wordguess version 1.0");
        System.out.println("Guesses left: " + setGuess(wordToGuess));
        System.out.println(formatArray(playerArray));
        while (gameOn) {

            System.out.println("Enter a single character: ");
            String userInput = scan.nextLine();
            if (checkWrongGuess(processInput(userInput), playerArray, gameArray)) {
                guessesLeft = changeGuessAmount(processInput(userInput), playerArray, gameArray, guessesLeft);
                System.out.println("You have " + guessesLeft + " guesses left.");
            }
            System.out.println(formatArray(updatePlayerArray(processInput(userInput), playerArray, gameArray)));
            if (guessesLeft == 0) {
                System.out.println(":-( You lose!");
                gameOn = false;
            }
            if (Arrays.equals(updatePlayerArray(processInput(userInput), playerArray, gameArray), gameArray)){
                System.out.println("Congrats! You won. Would you like to play again? (y/n)");
                playAgain = scan.next();
            }
            if (playAgain.equals("n")){
                playerQuitMessage();
                gameOn = false;
            }else{

            }


        }
    }

    // This method is passed a string array and returns a string

    public static String randWord(String[] arr) {
        int num = (int) (Math.random() * arr.length);
        return arr[num];
    }

    public static int setGuess(String s) {
        return s.length(); // integer used to set the guesses the player has
    }

    public static char[] setPlayerArr(String s) {

        // makes new charArr equal to length of randWord
        char[] playerArr = new char[setGuess(s)];
        for (int i = 0; i < setGuess(s); i++) {
            playerArr[i] = '_';
        }
        return playerArr;
    }

    public static char[] setGameArr(String s) {
        // makes new charArr equal to length of randWord
        char[] gameArr = new char[setGuess(s)];
        for (int i = 0; i < setGuess(s); i++) {
            gameArr[i] = s.charAt(i);
        }
        return gameArr;
    }


    // Takes in a charArr and formats it before returning it as a string
    public static String formatArray(char[] cArr) {
        return new String(cArr).replaceAll("", " ").trim();
    }


    public static boolean didPlayerQuit(String s) {
        return s.equals("-");
    }

    public static void playerQuitMessage() {
        System.out.println("Thank you for playing, please come again soon!");
    }

    public static char processInput(String s) {

        char cDefault = ' '; // Default

        if (didPlayerQuit(s)) {
            playerQuitMessage();
        } else {
            return s.charAt(0); // Returns the char value input by the user
        }
        return cDefault; // Returns the default
    }

    public static char[] updatePlayerArray(char c, char[] cArrToUpdate, char[] cArrToReference){

        if (c == ' '){
            return cArrToUpdate;
        } else{
            for (int i = 0; i < cArrToReference.length; i++){
                if (c == cArrToReference[i]){
                    cArrToUpdate[i] = c;
                }
            }
        }
        return cArrToUpdate;
    }

    public static boolean checkWrongGuess(char c, char[] cArrToUpdate, char[] cArrToReference){
        if (c == ' '){
            return true;
        }else{
            for (char value : cArrToReference){
                if (c == value){
                    return false;
                }
            }
        }
        return true;
    }

    public static int changeGuessAmount(char c, char[] cArrToUpdate, char[] cArrToReference, int guess){

        int changeGuess = 0;
        if (c == ' '){
            return changeGuess;
        } else{
            for (char value : cArrToReference) {
                if (c == value) {
                    return guess;
                }
            }
        }
        changeGuess = guess - 1;
        return changeGuess;

    }
}
