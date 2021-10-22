package com.valencia;

import java.util.Random;
import java.util.Scanner;

public class Matador {
    final int MIN_GUESS = 2;
    final int MAX_GUESS = 6;
    final private Die firstDie = new Die();
    final private Die secondDie = new Die();
    private int userScore = 0;
    private int computerScore = 0;
    private players roller = players.user;


    public Matador() {
        int guess = getGuess();

        while (userScore < 100 && computerScore < 100) {
            rollDice();
            printScores();
            printDice();

            if (isNumberOnTwoDice(1)) {
                System.out.println("! [1] appears on two dice. Score decreases by 25 points.");
                changeScore(-25);
                printScores();
                switchRoller();
            } else if (isNumberOneDie(1)) {
                System.out.println("! [1] appears on one die. Switch roller.");
                switchRoller();
            } else {
                changeScore(getTwoDiceValue());
                System.out.printf("! Score increases by %d.\n", getTwoDiceValue());

                if (isNumberOnTwoDice(guess)) {
                    System.out.printf("! [%d] appears on two dice! 🔥\n", guess);
                    break;
                } else if (isNumberOneDie(guess)) {
                    System.out.printf("! [%d] appears on one die. Roll again!\n", guess);
                } else {
                    switchRoller();
                }
            }
        }

        announceWinner();
    }

    private void changeScore(int score) {
        if (roller == players.user) {
            userScore += score;
        } else {
            computerScore += score;
        }
    }

    private int getGuess() {
        int guess;
        if (roller == players.user) {
            guess = getValidGuessFromUser();
        } else {
            guess = getGuessFromComputer();
        }

        return guess;
    }

    private void switchRoller() {
        roller = roller == players.user ? players.computer : players.user;
        System.out.printf("\n@ %s's Turn\n", roller == players.user ? "User" : "Computer");
    }

    private void printScores() {
        System.out.printf("+ User: %d - Computer: %d\n", userScore, computerScore);
    }

    private void announceWinner() {
        System.out.println("----------");
        System.out.printf("🎉 Congrats! The winner is %s 🎉\n", roller == players.user ? "User" : "Computer");
        printScores();
    }

    private int getValidGuessFromUser() {
        Scanner scanner = new Scanner(System.in);

        int guess;
        do {
            System.out.printf("> Enter guess [%d - %d]: ", MIN_GUESS, MAX_GUESS);
            guess = scanner.nextInt();
        } while (guess < MIN_GUESS || guess > MAX_GUESS);

        return guess;
    }

    private int getGuessFromComputer() {
        return new Random().nextInt(MIN_GUESS, MAX_GUESS + 1);
    }

    private boolean isNumberOnTwoDice(int number) {
        return firstDie.getValue() == number && secondDie.getValue() == number;
    }

    private boolean isNumberOneDie(int number) {
        return firstDie.getValue() == number || secondDie.getValue() == number;
    }

    private void rollDice() {
        firstDie.roll();
        secondDie.roll();
    }

    private void printDice() {
        System.out.printf("# First die: %d - Second die: %d\n", firstDie.getValue(), secondDie.getValue());
    }

    private int getTwoDiceValue() {
        return firstDie.getValue() + secondDie.getValue();
    }

    private enum players {user, computer}
}
