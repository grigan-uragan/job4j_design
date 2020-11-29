package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private static boolean findString(String whereFind, String target) {
        String[] strings = whereFind.split("\\s");
        int size = strings.length;
        if (size < 2) {
            return false;
        }

        return strings[size - 2].equals(target);
    }

    public static List<String> filter(String fileName) {
        BufferedReadFile readFile = new BufferedReadFile();
        List<String> temp = readFile.readLogFile(fileName);
        return temp.stream()
                .filter(s -> findString(s, "404"))
                .collect(Collectors.toList());
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out =
                     new PrintWriter(
                             new BufferedOutputStream(
                                     new FileOutputStream(file)))) {
            log.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       List<String> log = filter("log.txt");
       save(log, "404.txt");
    }
}
