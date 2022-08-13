package com.cna.cp2561;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

public class WordBank {
    static List<String> words = new LinkedList<>();

    /**
     * @param difficulty - integer value to indicate difficulty level
     * If difficulty is 1, load easyWords.txt; If difficulty is 2, load mediumWords.txt;
     * ...If difficulty is 3, load hardWords.txt.
     * Loads all words into the 'words' List based on 'difficulty' parameter
     */

    public static void loadWords(int difficulty) {

        String fileToLoad = "";
        switch (difficulty)
        {
            case 1:
                fileToLoad = "src/com/cna/cp2561/easyWords.txt";
                break;
            case 2:
                fileToLoad = "src/com/cna/cp2561/mediumWords.txt";
                break;
            case 3:
                fileToLoad = "src/com/cna/cp2561/hardWords.txt";
                break;
        }

        try(Scanner input = new Scanner(Paths.get(fileToLoad))) {
            while (input.hasNextLine())
            {
                words.add(input.nextLine());
            }
        }

        catch (IOException | NoSuchElementException | IllegalStateException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Generates a random word from the list of words
     * @return - returns a string of a random word
     */
    public static String getRandomWord()
    {
        String randomWord;
        Random random = new Random();
        int number = random.nextInt(words.size());

        randomWord = words.get(number);
        return randomWord;
    }
}
