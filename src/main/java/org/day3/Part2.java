package org.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Part2 {

    static Map<String, Integer> priorityMap = new HashMap<>();

    static Integer totalPrio = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\blitz\\Desktop\\repos\\class-repo\\adventofcode\\src\\main\\java\\org\\day3\\input.txt"));

        String string;

        while((string = reader.readLine()) != null) {
            String string2 = reader.readLine();
            String string3 = reader.readLine();

            String[] arr = string.split("");

            for (String str : arr) {
                if (string2.contains(str) && string3.contains(str)) {
                    totalPrio += priorityMap.get(str);
                    break;
                }
            }
        }

        System.out.println(totalPrio);
    }
}
