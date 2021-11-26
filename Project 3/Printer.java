package com.valencia;

public class Printer {
    public static void printNames(String[] names) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}
