package org.day7.models;

import org.day7.Part1and2;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private List<Directory> children = new ArrayList<>();
    private List<File> files = new ArrayList<>();
    private final Directory MOTHER; //each directory knows its mother

    private final String name;

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
            return Part1and2.ROOT;
        }

        return children.stream()
                .filter(dir -> dir.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void fillListWithTotalSizes(List<Integer> list) {
        list.add(getTotalSize());

        for (Directory dir : children) {
            dir.fillListWithTotalSizes(list);
        }
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
}
