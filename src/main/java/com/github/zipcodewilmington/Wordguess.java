package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Scanner;

public class Wordguess {

    String[] wordBank = {"cat", "dog", "laptop", "zipcode", "spider-man"};


    public void runGame() {

        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        System.out.println("This is the game running");
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


        char c = ' '; // come back to this

        if (didPlayerQuit(s)) {
            playerQuitMessage();
        } else {
            for (int i : setGameArr(s)) {
                String arrToString = String.valueOf((setGameArr(s))[i]);

            }
        }
        return c;
    }

    public static char[] updatePlayerArray(char c){


        return null;
    }








//          String[] noSpaces = phrase.split(" "); // creates string array with each word in the original string
//          int wordCount = noSpaces.length; // Creates integer equal to the number of words in the string array
//
//
//          char firstLetter;
//          String wordBuilder = "";
//          for (int i = 0; i < wordCount; i++){
//              String arrToString = noSpaces[i];
//              firstLetter = arrToString.charAt(0);
//              wordBuilder = wordBuilder.concat(String.valueOf(firstLetter)).toUpperCase() ;
//          }
//          return wordBuilder;
}


