package org.day7;

import org.day7.models.Directory;
import org.day7.models.File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static final Directory ROOT = new Directory("/", null);
    private static Directory currentDirectory;
    private static String line;
    private static BufferedReader reader;
    private static boolean listMode = false;

    public static void main(String[] args) {

        try {
            reader = new BufferedReader(new FileReader("src/main/java/org/day7/input.txt"));
            reader.readLine(); //skipping first line
        } catch (IOException e) {
            e.printStackTrace();
        }

        currentDirectory = ROOT;

        try {
            read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void read() throws IOException {

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (listMode) {
                listCommand();
                continue;
            }

            switch (line.charAt(0)) {
                case '$':
                    chooseCommand();
            }
        }
    }

    private static void chooseCommand() {
        switch (line.charAt(2)) {
            case 'c': //c for cd, no need to make a substring
                currentDirectory = currentDirectory.getChildByName(line.substring(5));
                break;
            case 'l': //same here
                try {
                    reader.readLine();
                    listCommand();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                break;
        }
    }

    private static void listCommand() throws IOException {

        listMode = true;
        if ((line) != null && line.charAt(0) != '$') {

            Pattern filePattern = Pattern.compile("[0-9]+");

            String[] splitLine = line.split(" ");
            Matcher matcher = filePattern.matcher(splitLine[0]);
            if (matcher.find()) {
                currentDirectory.addFile(new File(splitLine[1], Integer.parseInt(splitLine[0])));
            }
            //second if just to make sure nothing else comes in here
            if (splitLine[0].equals("dir")) {
                currentDirectory.addDirectory(new Directory(splitLine[1], currentDirectory));
            }
        } else {
            listMode = false;
        }
    }


}
