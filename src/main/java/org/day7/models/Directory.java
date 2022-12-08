package org.day7.models;

import org.day7.Part1;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private List<Directory> children = new ArrayList<>();
    private List<File> files = new ArrayList<>();
    private final Directory MOTHER;



    private String name;

    public Directory(String name, Directory mother) {
        this.MOTHER = mother;
        this.name = name;
    }

    public int getTotalSize() {
        int size = 0;

        if (!files.isEmpty()) {
            size += files.stream().map(File::getSize).reduce(Integer::sum).get();
        }

        if (!children.isEmpty()) {
            size += children.stream().map(Directory::getTotalSize).reduce(Integer::sum).get();
        }

        return size;
    }

    public Directory getChildByName(String name) {
        if (name.equals("..")) {
            return MOTHER;
        }

        if (name.equals("/")) {
            return Part1.ROOT;
        }

        return children.stream()
                .filter(dir -> dir.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        children.add(directory);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "children=" + children +
                ", files=" + files +
                ", MOTHER=" + MOTHER +
                ", name='" + name + '\'' +
                '}';
    }
}
