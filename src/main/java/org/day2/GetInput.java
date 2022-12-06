package org.day2;

public class GetInput {

    public Play disambiguate(String string) {

        return Enum.valueOf(Play.class, string);
    }
}
