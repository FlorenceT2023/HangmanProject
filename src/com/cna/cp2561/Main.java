package com.cna.cp2561;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        boolean weArePlaying = true;
        while (weArePlaying)
        {
            WordBank.loadWords(1);
            String randomWord = WordBank.getRandomWord();
            System.out.printf("The random word is \"%s\"%n", randomWord);

            char randomWordToGuess[] = randomWord.toCharArray();
            int amountOfGuesses = randomWordToGuess.length;
            char playerGuess[] = new char[amountOfGuesses];

            Arrays.fill(playerGuess, '_');

            boolean wordIsGuessed = false;
            int tries = 0;

            while (!wordIsGuessed && tries != amountOfGuesses +3)
            {
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d amount of tries left.\n", (amountOfGuesses +3)-tries);
                System.out.println("Enter a single character: ");
                char input = scanner.nextLine().charAt(0);
                tries++;

                if (input == '-'){
                    wordIsGuessed = true;
                    weArePlaying = false;
                }
                else {
                    for (int i = 0; i < randomWordToGuess.length; i++)
                    {
                        if(randomWordToGuess[i] == input)
                        {
                            playerGuess[i] = input;
                        }
                    }
                    if(isTheWordGuessed(playerGuess))
                    {
                        wordIsGuessed = true;
                        System.out.println("Congratulations");
                    }
                }
            }
            if(!wordIsGuessed)
            {
                System.out.println("You ran out of guesses.");
            }
            System.out.println("Would like to play again? (yes/no)");
            String choice = scanner.nextLine();
            if(choice.equals("no")){
                weArePlaying = false;
            } else if (choice.equals("yes")) {
                weArePlaying = true;
            }

        }
        System.out.println("Game Over!");

    }

    public static void print(char array[]){
        for(int i=0; i<array.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '_'){
                condition = false;
            }
        }
        return condition;
    }
}
