package org.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAIN {
    public static void main(String[] args) throws IOException {

        Integer goalCount = 0;

        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/day4/input.txt"));

        String line = "";

        while ((line = reader.readLine()) != null) {
            String[] lineSplit = line.split(",");

            List<Integer> firstHalf = new ArrayList<>();
            List<Integer> secondHalf = new ArrayList<>();

            firstHalf.add(Integer.parseInt(lineSplit[0].split("-")[0]));
            firstHalf.add(Integer.parseInt(lineSplit[0].split("-")[1]));
            secondHalf.add(Integer.parseInt(lineSplit[1].split("-")[0]));
            secondHalf.add(Integer.parseInt(lineSplit[1].split("-")[1]));
            //very lazy xd was to test something weird occurring in js

            if (firstHalf.get(0) <= secondHalf.get(0) && firstHalf.get(1) >= secondHalf.get(1)) {
                goalCount++;
            } else if (firstHalf.get(0) >= secondHalf.get(0) && firstHalf.get(1) <= secondHalf.get(1)) {
                goalCount++;
            }
        }

        System.out.println(goalCount);
    }
}
