package com.github.zipcodewilmington;

import java.util.Scanner;

public class Wordguess {

    String[] wordBank = {"cat", "dog", "laptop", "zipcode", "spider-man"};


    public void runGame(String[] wb) {

        Scanner scan = new Scanner(System.in);

        //wordToGuess is now the random word from the wordBank
        String wordToGuess = randWord(wb);

        //guessesLeft is equal to the length of wordToGuess
        int guessesLeft = setGuess(wordToGuess);

        //player array is a blank array with '_' the length of wordToGuess
        char[] playerArray = setPlayerArr(wordToGuess);
        //game array is an array with the length and chars of wordToGuess
        char[] gameArray = setGameArr(wordToGuess);

        //formats player array and outputs
        System.out.println(formatArray(playerArray));
        //formats game array and outputs
        System.out.println(formatArray(gameArray));
        //prints how many guesses the player has
        System.out.println(setGuess(wordToGuess));

        System.out.println("Enter a letter you want to guess: ");
        String userInput = scan.nextLine();
        //takes in string and returns a char equal to that input
        char userChar = processInput(userInput);
        //takes in the user input as a char and the gameArray and checks to see if user input exists in game array
        char[] alteredArr = updatePlayerArray(userChar, setPlayerArr(wordToGuess), setGameArr(wordToGuess));
        System.out.println(formatArray(alteredArr));
        //Outputs the number of guesses the user has left
        System.out.println(checkWrongGuess(userChar, setPlayerArr(wordToGuess), setGameArr(wordToGuess), guessesLeft));

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

    //
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

    public static int checkWrongGuess(char c, char[] cArrToUpdate, char[] cArrToReference, int guess){

        int changeGuess = guess;
        if (c == ' '){
            return changeGuess;
        } else{
            for (char value : cArrToReference) {
                if (c == value) {
                    return guess;
                }
            }
        }
        guess--;
        changeGuess = guess;
        return changeGuess;
    }
}


