package org.day7.models;

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
}
