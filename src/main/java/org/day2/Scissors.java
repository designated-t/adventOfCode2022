package org.day2;

public class Scissors implements Input {

    @Override
    public String getTheClass() {
        return "SCISSOR";
    }

    @Override
    public void performPlay(String input) {
        switch (input) {
            case "X":
                Main.ownScore += 2;
                return;
            case "Y":
                Main.ownScore += 6;
                return;
            case "Z":
                Main.ownScore += 7;
        }
    }
}
