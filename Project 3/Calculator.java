package com.valencia;

public class Calculator {
    public void printAverage(int[] ints) {
        System.out.print("! Average of integers ( ");
        for (int number : ints) {
            System.out.printf("%d ", number);
        }
        System.out.printf(") is %.2f", calculateAverage(ints));
        System.out.println();
    }

    public void printAverage(double[] doubles) {
        System.out.print("! Average of doubles ( ");
        for (double number : doubles) {
            System.out.printf("%.2f ", number);
        }
        System.out.printf(") is %.2f\n", calculateAverage(doubles));
    }

    private double calculateAverage(int[] ints) {
        int total = 0;
        int size = ints.length;

        for (int number : ints) {
            total += number;
        }

        return (double) total / size;
    }

    private double calculateAverage(double[] doubles) {
        double total = 0;
        int size = doubles.length;

        for (double number : doubles) {
            total += number;
        }

        return total / size;
    }
}
