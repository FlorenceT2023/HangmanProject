package com.cna.cp2561;

public class Main {

    public static void main(String[] args) {
        WordBank.loadWords(1);
        System.out.println(WordBank.getRandomWord());
    }
}
