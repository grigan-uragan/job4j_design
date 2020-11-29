package io;

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
        List<String> result = temp.stream()
                .filter(s -> findString(s, "404"))
                .collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        filter("log.txt").forEach(System.out::println);
    }
}
