package com.cna.cp2561;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class Title {
    public static void displayTitle() {

        // reads title txt file and displays it
        try(Scanner title = new Scanner(Paths.get("hangmanTitle.txt"))) {

            while(title.hasNextLine()) {
                System.out.println(title.nextLine());
            }
        } catch (FileNotFoundException | SecurityException | FormatterClosedException ex) {
            ex.printStackTrace();
            System.exit(1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
