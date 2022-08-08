package com.cna.cp2561;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // reads title txt file and displays it
        try(Scanner input = new Scanner(Paths.get("hangmanTitle.txt"))) {

            while(input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException | SecurityException | FormatterClosedException ex) {
            ex.printStackTrace();
            System.exit(1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();


        Scanner scanner = new Scanner(System.in);

        boolean play = true;
        while (play)
        {
            WordBank.loadWords(1);
            String randomWord = WordBank.getRandomWord();
            System.out.printf("The random word is \"%s\"%n", randomWord);
            String[] randomWordArray = randomWord.split("");
            ArrayList<String> mainRandomWordArray = new ArrayList<>(Arrays.asList(randomWordArray));
            int amountOfGuesses = Display.arrDisplay.length;

            ArrayList<String> hashedArray = generateHashedArray(mainRandomWordArray);
            System.out.println();

            boolean wordIsGuessed = false;
            int tries = 0;

            while (!wordIsGuessed & tries != amountOfGuesses)
            {
                System.out.println("Current Guesses: ");
                printArrayContent(hashedArray);
                System.out.printf("You have %d amount of tries left.\n", (amountOfGuesses)-tries);
                System.out.println("Enter a single letter: ");
                String input = scanner.next();


                if (input.equals("-"))
                {
                    play = false;
                    wordIsGuessed = true;
                    System.out.println("Game Over!");
                }

                else if (!mainRandomWordArray.contains(input)){

                    tries++;

                }
                else {
                    for(int i = 0; i < mainRandomWordArray.size(); i++)
                    {
                        if(mainRandomWordArray.get(i).equals(input))
                        {
                            hashedArray.set(i, input);
                        }

                    }
                    if(mainRandomWordArray.equals(hashedArray))
                    {
                        wordIsGuessed = true;
                        System.out.println("Congratulations!");
                        System.out.print("You spelled ");
                        printArrayContent(hashedArray);
                    }
                }
                if (amountOfGuesses == tries)
                {
                    wordIsGuessed = true;
                }
                else {
                    System.out.println(Display.arrDisplay[tries]);
                }


            }// END of inner while loop
            if(amountOfGuesses == tries)
            {
                System.out.println("You ran out of guesses.");
            }
            System.out.println("Would like to play again? (yes/no)");
            scanner.nextLine();
            String choice = scanner.nextLine();
            if(choice.equals("no")){
                play = false;
            } else if (choice.equals("yes")) {
                play = true;
            }

        }// END of outer while loop
        System.out.println("Game Over!");
    }

    public static ArrayList<String> generateHashedArray(ArrayList<String> mainArray)
    {
        ArrayList<String> hashedWordArray = new ArrayList<>();
        for (String s: mainArray){
            hashedWordArray.add("_");
        }
        return hashedWordArray;
    }

    public static void printArrayContent(ArrayList<String> arr)
    {
        for (String s: arr){
            System.out.print(s);
        }
        System.out.println();
    }
}
