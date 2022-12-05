package org.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Part1and2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\blitz\\Desktop\\repos\\class-repo\\adventofcode\\src\\main\\java\\org\\day1\\input.txt"));

        String string;

        List<Integer> subList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        while((string = bufferedReader.readLine()) != null) {
            if(string.equals("")) {
                list.add(subList.stream().reduce(Integer::sum).get()); //direct get() since I know it has something in it
                subList.clear(); //
                continue;
            }
            subList.add(Integer.parseInt(string));
        }

        list.sort(Integer::compareTo); //looks janky, but I did it this way as to not require separate method calls from a Main instance.
        list.sort(Comparator.reverseOrder()); //let me know how else you'd do it without making a Main instance. If you try, you'll see.
        System.out.println(list.get(0)); //part 1
        System.out.println(list.get(0) + list.get(1) + list.get(2)); //part 2
    }
}
