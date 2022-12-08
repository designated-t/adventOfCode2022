package org.day7.models;

import java.util.List;

public class File {

    public String name;
    public int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }


    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
