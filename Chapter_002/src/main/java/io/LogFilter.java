package io;

import java.io.*;
import java.util.ArrayList;
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
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            result = reader.lines()
                    .filter(s -> findString(s, "404"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

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
