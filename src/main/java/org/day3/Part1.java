package org.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Part1 {

    static Map<String, Integer> priorityMap = new HashMap<>();

    static Integer totalPrio = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\blitz\\Desktop\\repos\\class-repo\\adventofcode\\src\\main\\java\\org\\day3\\input.txt"));

        createMapping();

        String string;

        while((string = reader.readLine()) != null) {
            //String string2 = reader.readLine();
            //String string3 = reader.readLine(); // PART 2

            String[] arr = string.split("");

            /*for (String str : arr) {
                if (string2.contains(str) && string3.contains(str)) {
                    totalPrio += priorityMap.get(str);
                    break;  THIS WAS THE PART 2
                }
            }*/

            int arrHalf = arr.length / 2;
            verify(arrHalf, arr); //THIS WAS THE PART 1
        }

        System.out.println(totalPrio);
    }

    private static void verify(int arrHalf, String[] arr) {
        for (int i = 0; i < arrHalf; i++) {
            for (int j = arrHalf; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    totalPrio += priorityMap.get(arr[i]);
                    return;
                }
            }
        }
    }

    private static void createMapping() {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (int i = 0; i < alphabet.length; i++) {
            priorityMap.put(alphabet[i], i+1);
        }
    }
}
