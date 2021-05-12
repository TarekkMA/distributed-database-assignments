package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Write a program that reads a text file, specified by the first command line argument, into a List.
 * The program should then print random lines from the file, the number of lines printed to be specified by
 * the second command line argument. Write the program so that a correctly sized collection is allocated all
 * at once, instead of being gradually expanded as the file is read in. Hint: To determine the number of
 * lines in the file, use java.io.File.length to obtain the size of the file, then divide by an assumed size
 * of an average line.
 */
public class Question_3 {

    public static void main(String[] args) throws IOException {
        Random r = new Random();

        String path = /*args[1]*/ "./shakespeare.txt";
        int lineToPrint = /*Integer.parseInt(args[2])*/r.nextInt(10) + 1;

        List<String> lines = Files.lines(Paths.get("./shakespeare.txt")).collect(Collectors.toList());

        for (int i = 0; i < lineToPrint; i++) {
            int lineIndex = r.nextInt(lines.size());
            String line = lines.get(lineIndex);

            System.out.println("[" + (i + 1) + "] Line " + lineIndex + ":\t" + line);
        }
    }

}
