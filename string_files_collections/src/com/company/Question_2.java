package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Write an example that counts the number of times a particular character, such as e,
 * appears in a file. The character can be specified at the command line.
 */
public class Question_2 {
    static String charToCount;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the character: ");
            charToCount = scanner.nextLine();
            if (charToCount.length() == 1) {
                break;
            }
            System.out.println("Only enter one character");
        }

        long count = Files.lines(Paths.get("./shakespeare.txt"))
                .flatMapToInt(l -> l.chars().filter(c -> c == charToCount.codePointAt(0)))
                .count();

        System.out.println("Char '" + charToCount + "' found " + count + " times");
    }

}
