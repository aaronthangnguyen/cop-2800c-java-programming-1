package com.valencia;

import java.util.Scanner;

public class Guess {
    final int MIN_GUESS = 2;
    final int MAX_GUESS = 12;
    final int MAX_TRIES = 3;

    final private Die firstDie = new Die();
    final private Die secondDie = new Die();

    public Guess() {
        int guess = getValidGuessFromPlayer();
        System.out.println();
        boolean result = isGuessCorrectWithinMaxTries(guess);
        System.out.println();
        announceResult(result);
    }

    private boolean isGuessCorrectWithinMaxTries(int guess) {
        for (int i = 0; i < MAX_TRIES; i++) {
            int totalDiceValue = firstDie.getValue() + secondDie.getValue();
            System.out.printf("Dice value: %d (%d + %d)\n", totalDiceValue, firstDie.getValue(), secondDie.getValue());
            if (guess == totalDiceValue) {
                return true;
            } else {
                firstDie.roll();
                secondDie.roll();
            }
        }

        return false;
    }

    private int getValidGuessFromPlayer() {
        Scanner scanner = new Scanner(System.in);

        int guess;
        do {
            System.out.printf("> Enter guess [%d - %d]: ", MIN_GUESS, MAX_GUESS);
            guess = scanner.nextInt();
        } while (guess < MIN_GUESS || guess > MAX_GUESS);

        return guess;
    }

    private void announceResult(boolean result) {
        if (result) {
            System.out.println("🎉 Congrats! 🎉");
        } else {
            System.out.println("🥸 Good luck next time! 🥸");
        }
    }
}
