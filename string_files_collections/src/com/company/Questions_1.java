package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Write a program that computes your initials from your full name and displays them.
 */
public class Questions_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Name:");
        String name = scanner.nextLine();
        String initials = Arrays
                .stream(name.split(" "))
                .map(s -> String.valueOf(s.charAt(0)).toUpperCase())
                .collect(Collectors.joining(" "));

        System.out.println("Your initials is: " + initials);
    }
}
