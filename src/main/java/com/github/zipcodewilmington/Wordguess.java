package com.github.zipcodewilmington;

public class Wordguess {

    String[] wordBank = {"cat", "dog", "house", "laptop", "zipcode"};


    public void runGame(){
        System.out.println("This is the game running");
    }

    // This method is passed a string array and returns a string

    public static String randWord(String[] arr){
        int num = (int) (Math.random() * arr.length);
        return arr[num];
    }

    public static int setGuess(String s){
        return s.length();
    }

    public static String[] setArr(String s){
        return null;
    }

}


