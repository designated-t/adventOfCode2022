package org.day2;

public class Paper implements Input {

    @Override
    public String getTheClass() {
        return "PAPER";
    }

    @Override
    public void performPlay(String input) {
        switch (input) {
            case "X":
                Main.ownScore += 1;
                return;
            case "Y":
                Main.ownScore += 5;
                return;
            case "Z":
                Main.ownScore += 9;
        }
    }
}
