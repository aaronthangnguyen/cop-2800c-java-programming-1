package com.valencia;

public class Main {

    public static void main(String[] args) {
        // Part 1. Print names
        System.out.println("PART 1. PRINT NAMES");
        String[] names = {"alice", "bob", "carla", "donald", "earl", "felicia"};
        Printer.printNames(names);

        System.out.println();

        // Part 2. Calculate average
        System.out.println("PART 2. CALCULATE AVERAGES");

        Calculator calculator = new Calculator();

        // Calculate integers average
        int[] ints = {3, 2, 1, 5, 9};
        calculator.printAverage(ints);

        // Calculate doubles average
        double[] doubles = {3.14, 2.51, 1.95, 5.12, 9.69};
        calculator.printAverage(doubles);

        System.out.println();

        // Part 3. Manage Valencia Ice Cream Shoppe
        System.out.println("PART 3. VALENCIA ICE CREAM SHOPPE");
        ValenciaIceCreamShoppe shop = new ValenciaIceCreamShoppe();
        shop.printBonus();

    }
}
