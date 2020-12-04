package io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File(
                "/Users/Admin/IdeaProjects/job4j_design/Chapter_002/src/main/java/io");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s",
                    file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s",
                    file.getAbsoluteFile()));
        }
        System.out.println("size : " + file.getTotalSpace());
        for (File subFile : file.listFiles()) {
            System.out.println(subFile.getName()
                    + " - " + subFile.length() + " Byte");
        }
    }
}
