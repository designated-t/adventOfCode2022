package org.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static Integer ownScore = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/day2/input.txt"));

        GetInput getInput = new GetInput();

        String string;

        while((string = reader.readLine()) != null) {
            String[] choices = string.split(" ");

            Play play = getInput.disambiguate(choices[0]);

            play.input.performPlay(choices[1]);
        }

        System.out.println(ownScore);
    }
}