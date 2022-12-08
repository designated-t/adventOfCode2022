package org.day7;

import org.day7.models.Directory;
import org.day7.models.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1and2 {

    public static final Directory ROOT = new Directory("/", null);
    private static Directory currentDirectory;
    private static String line;
    private static BufferedReader reader;
    private static final int MAX_SIZE = 100000; //max size for finding PART 1 CONSTANT

    private static final int TOTAL_STORAGE = 70000000; //total storage to be had PART 2 CONSTANT
    private static final int UPDATE_SIZE = 30000000; //size of the update PART 2 CONSTANT

    public static void main(String[] args) {

        currentDirectory = ROOT;

        try {

            reader = new BufferedReader(new FileReader("src/main/java/org/day7/input.txt"));
            reader.readLine(); //skipping first line since it just changes directory to ROOT, my logic won't work well with it
            read();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        LinkedList<Integer> list = new LinkedList<>();
        ROOT.fillListWithTotalSizes(list);
        //I fill a list with all the sizes of all the directories. This allows me to then just take the values as I please
        //applying whatever logic I so desire. Still, rather flawed for general purpose since It will give me the size of
        //inner directories and outer directories alike. Literally all that exist. Though for this exercise, works perfectly

        System.out.println(list.stream()
                .filter(val -> val < MAX_SIZE)
                .reduce(Integer::sum) + " the sum of all the largest directories up to a given maximum: " + MAX_SIZE); //part1

        System.out.println(list.stream()
                .filter(val -> val > (UPDATE_SIZE - (TOTAL_STORAGE - ROOT.getTotalSize())))
                .min(Integer::compareTo) + " smallest directory's size which, if deleted, will give the file system " +
                "enough memory to apply the update(UPDATE SIZE: " + UPDATE_SIZE + "; AVAILABLE MEMORY: " + (TOTAL_STORAGE - ROOT.getTotalSize()) + ")"); //part2
    }

    private static void read() throws IOException {
        while ((line = reader.readLine()) != null) {

            if (line.startsWith("$ cd")) {
                currentDirectory = currentDirectory.getChildByName(line.substring(5));
                continue;
            }

            if (line.startsWith("$ ls")) {
                continue;
            }

            Pattern filePattern = Pattern.compile("[0-9]+");

            String[] splitLine = line.split(" ");
            Matcher matcher = filePattern.matcher(splitLine[0]);

            if (matcher.find()) {
                currentDirectory.addFile(new File(splitLine[1], Integer.parseInt(splitLine[0])));
                continue;
            }

            if (splitLine[0].equals("dir")) { //an if just to make sure :)
                currentDirectory.addDirectory(new Directory(splitLine[1], currentDirectory));
            }
        }
    }
}
