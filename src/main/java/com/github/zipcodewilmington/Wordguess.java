package com.github.zipcodewilmington;

import java.lang.reflect.Array;

public class Wordguess {

    String[] wordBank = {"cat", "dog", "laptop", "zipcode", "spider-man"};


    public void runGame(){

        System.out.println("This is the game running");
        String wordToGuess = randWord(wordBank);
        int guessesLeft = setGuess(wordToGuess);
        char[] playerArr = setPlayerArr(wordToGuess);
        char[] gameArr = setGameArr(wordToGuess);

        System.out.println(arrToStringFormat(playerArr));
        System.out.println(arrToStringFormat(gameArr));

    }


    // This method is passed a string array and returns a string

    public static String randWord(String[] arr){
        int num = (int) (Math.random() * arr.length);
        return arr[num];
    }

    public static int setGuess(String s){
        return s.length(); // integer used to set the guesses the player has
    }

    public static char[] setPlayerArr(String s){

        // makes new charArr equal to length of randWord
        char[] playerArr = new char[setGuess(s)];
        for (int i = 0; i < setGuess(s); i++){
            playerArr[i] = '_';
        }
//        for (int i = 0; i < setGuess(s) * 2; i++){ // iterates through each index of the new array
//            if ((i) % 2 == 0){ // if the index is even
//                playerArr[i] = '_'; // replace the index of the charArr with the charAt the index of s
//            }else{ // if the index is odd
//                playerArr[i] = ' '; // replace the index of the charArr with ' '
//            }
//        }
        return playerArr;
    }

    public static char[] setGameArr(String s){
        // makes new charArr equal to length of randWord
        char[] gameArr = new char[setGuess(s)];
        for (int i = 0; i < setGuess(s); i++){
            gameArr[i] = s.charAt(i);
        }
//        for (int i = 0; i < setGuess(s) * 2; i++){ // iterates through each index of the new array
//            if ((i) % 2 == 0){ // if the index is even
//                gameArr[i] = s.charAt(i); // replace the index of the charArr with the charAt the index of s
//            }else{ // if the index is odd
//                gameArr[i] = ' '; // replace the index of the charArr with ' '
//            }
//        }
        return gameArr;
    }

    public static String arrToStringFormat(char[] cArr){
        return new String(cArr).replaceAll("", " ").trim();
    }
}


