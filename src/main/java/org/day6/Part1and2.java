package org.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1and2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/day6/input.txt"));

        String line = reader.readLine(); //this input is just 1 line lol

        doThing(line, 14);
        // for part 1, change the second parameter to 4.
        // This functions for any amount of distinct characters btw

    }

    public static void doThing(String line, int distinctCharAmount) {
        for (int i = distinctCharAmount; i < line.length(); i++) {

            String subString = line.substring(i - distinctCharAmount, i);

            int count = 0;
            for (String str : subString.split("")) {

                if (subString.lastIndexOf(str) != subString.indexOf(str)) {
                    break;
                }

                count++;

                if (count == distinctCharAmount) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
