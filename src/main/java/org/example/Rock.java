package org.example;

public class Rock implements Input{


    public String getTheClass() {
        return "ROCK";
    }

    @Override
    public void performPlay(String input) {
        switch (input) {
            case "X":
                Main.ownScore += 3;
                return;
            case "Y":
                Main.ownScore += 4;
                return;
            case "Z":
                Main.ownScore += 8;
        }
    }
}
