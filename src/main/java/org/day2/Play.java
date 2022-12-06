package org.day2;

public enum Play {

    A(new Rock()),
    B(new Paper()),
    C(new Scissors()),
    X(new Rock()),
    Y(new Paper()),
    Z(new Scissors());

    Input input;

    Play(Input input) {
        this.input = input;
    }
}
