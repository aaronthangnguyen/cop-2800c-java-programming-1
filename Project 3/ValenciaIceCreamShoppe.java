package com.valencia;

import java.util.Scanner;

public class ValenciaIceCreamShoppe {
    private final int[][] bonusTable = {
            {25, 45, 80, 110, 150},
            {50, 60, 90, 120, 180},
            {100, 125, 160, 210, 265},
            {160, 190, 225, 275, 340},
            {230, 265, 325, 385, 450},
            {300, 360, 420, 480, 600},
            {425, 500, 600, 725, 875}
    };
    private final Scanner in = new Scanner(System.in);

    public void printBonus() {
        int totalBonus = 0;
        boolean isContinued;

        do {
            int week = getWeekFromInput();
            int review = getReviewFromInput();

            int bonus = getBonus(week, review);

            System.out.printf("! Bonus for working %d week(s) and received %d positive review(s) is $%d\n", week, review, bonus);

            totalBonus += bonus;

            System.out.print("? Continue (1 to continue, 0 to stop): ");

            isContinued = in.nextInt() != 0;

            System.out.println();
        } while (isContinued);

        System.out.printf("! Total bonus is $%d", totalBonus);
    }

    private int getBonus(int week, int review) {
        int valid_week = validateWeek(week);
        int valid_review = validateReview(review);

        return bonusTable[valid_week][valid_review];
    }

    private int validateWeek(int week) {
        int MAX_WEEK = 6;
        return Math.min(week, MAX_WEEK);
    }

    private int validateReview(int review) {
        int MAX_REVIEW = 4;
        return Math.min(review, MAX_REVIEW);
    }

    private int getWeekFromInput() {
        int input;

        do {
            System.out.print("? Enter week (>=0): ");
            input = in.nextInt();
        } while (input < 0);

        return input;
    }

    private int getReviewFromInput() {
        int input;

        do {
            System.out.print("? Enter review (>=0): ");
            input = in.nextInt();
        } while (input < 0);

        return input;
    }
}
