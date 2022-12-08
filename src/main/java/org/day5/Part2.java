package org.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static LinkedList<LinkedList<String>> stackList = new LinkedList<>();

    public static int STACK_COUNT = 9; //change this based on how many stacks there are in the initial input. Default is 9.

    public static void main(String[] args) throws IOException {

        populateLinkedList();

        Pattern pattern = Pattern.compile("\\[[a-zA-Z]]");
        //regex is fun
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/day5/input.txt"));

        String line;

        Boolean instructionPhase = false;

        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher((line));
            if (!instructionPhase && matcher.find()) {

                StringBuilder stringToAdd = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) == '[') {
                        stringToAdd.append(line, i, i + 3);

                        populateStacks((i + 3) / 4, stringToAdd.toString());
                        //I add 4 to I because of the starting value(0, not 1) and because I use a 4 case basis to
                        //determine the width of a column. For example, "[A] " has 4 characters. This is a column.
                        //establishing this allows me to acquire the effective stack index which consequently
                        //allows me to use it as an index for the stackList.

                        stringToAdd.delete(0, stringToAdd.toString().length());
                    }
                }
            } else if (line.equals("")){
                instructionPhase = true;
                continue;
            }

            if (instructionPhase) {
                String[] splitLine = line.split(" ");
                performAction(Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[5]));
                //looks ugly, but using streams would have heavier logic since I'd be also checking for if the element is a
                //convertable string or not. This is simpler, though it may look rather ugly.
            }
        }

        StringBuilder builder = new StringBuilder();
        stackList.stream().forEach(stack -> builder.append(stack.get(0).charAt(1)));

        System.out.println(builder);
    }

    private static void populateLinkedList() {
        for (int i = 0; i < STACK_COUNT; i++) {
            stackList.add(new LinkedList<>());
        }
    }


    private static void populateStacks(Integer index, String obj) {
        stackList.get(index).addLast(obj);
    }

    /**
     * @param amount    Amount of boxes to remove from a stack
     * @param indexFrom Index of the stack in the array where to take the boxes from
     * @param indexTo   Index of the stack in the array where to put the boxes to
     */
    public static void performAction(Integer amount, Integer indexFrom, Integer indexTo) {
        LinkedList<String> localList = new LinkedList<>();

        for (int i = 0; i < amount; i++) {
            localList.push(stackList.get(indexFrom - 1).pop());
        }

        localList.forEach(item -> stackList.get(indexTo - 1).push(item));
    }
}
